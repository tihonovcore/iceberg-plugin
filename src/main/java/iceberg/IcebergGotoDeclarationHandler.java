package iceberg;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.execution.RunManager;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.psi.*;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import iceberg.psi.*;
import iceberg.run.IcebergRunConfiguration;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

//NOTE: правильнее реализовывать простые прыжки через PsiReference,
// чтобы работало переименование и подсветка, а GotoDeclarationHandler
// использовать только для странных прыжков во вне IDE (.h файлы, например)
public class IcebergGotoDeclarationHandler implements GotoDeclarationHandler {
    @Override
    public PsiElement @Nullable [] getGotoDeclarationTargets(
        @Nullable PsiElement sourceElement, int offset, Editor editor
    ) {
        if (sourceElement == null) {
            return PsiElement.EMPTY_ARRAY;
        }

        //sourceElement is leaf
        var element = sourceElement.getParent();

        if (element instanceof IcebergClassReference) {
            var className = element.getText();
            var userDefinedClasses = PsiTreeUtil.findChildrenOfType(
                element.getContainingFile(),
                IcebergClassDefinitionStatement.class
            );
            for (var def : userDefinedClasses) {
                var actual = def.getClassIdentifier().getText();
                if (actual.equals(className)) {
                    return new PsiElement[]{def.getClassIdentifier()};
                }
            }

            var importedClasses = PsiTreeUtil.findChildrenOfType(
                element.getContainingFile(),
                IcebergDependency.class
            );

            for (var imported : importedClasses) {
                var actual = imported.getDepIdentifierList().getLast().getText();
                if (actual.equals(className)) {
                    return jumpFromImport(imported);
                }
            }

            return PsiElement.EMPTY_ARRAY;
        }

        if (element instanceof IcebergClassIdentifier) {
            var className = element.getText();
            var classUsages = PsiTreeUtil.findChildrenOfType(
                element.getContainingFile(),
                IcebergClassReference.class
            );
            return classUsages.stream()
                .filter(ref -> ref.getText().equals(className))
                .toArray(PsiElement[]::new);
        }

        if (element instanceof IcebergDepIdentifier) {
            var imported = (IcebergDependency) element.getParent();
            return jumpFromImport(imported);
        }

        //NOTE: для переменных нужен анализ скоупов
        //NOTE: для функций нужен анализ типов аргументов

        return PsiElement.EMPTY_ARRAY;
    }

    private PsiElement @Nullable [] jumpFromImport(IcebergDependency imported) {
        var fqn = imported.getDepIdentifierList().stream()
            .map(PsiElement::getText)
            .collect(Collectors.joining("."));

        var facade = JavaPsiFacade.getInstance(imported.getProject());
        var psiClass = facade.findClass(fqn, GlobalSearchScope.allScope(imported.getProject()));
        if (psiClass != null) {
            return new PsiElement[]{psiClass};
        }

        var runManager = RunManager.getInstance(imported.getProject());
        var classPaths = runManager.getAllConfigurationsList().stream()
            .filter(IcebergRunConfiguration.class::isInstance)
            .map(IcebergRunConfiguration.class::cast)
            .filter(cfg -> {
                var expected = imported.getContainingFile().getVirtualFile().getPath();
                return expected.equals(cfg.getProgramFilePath());
            })
            .map(IcebergRunConfiguration::getClasspath)
            .flatMap(Collection::stream)
            .distinct()
            .toList();

        //TODO: support jars
        var suffix = imported.getDepIdentifierList().stream()
            .map(PsiElement::getText)
            .collect(Collectors.joining(File.separator)) + ".class";

        var localFileSystem = LocalFileSystem.getInstance();
        var psiManager = PsiManager.getInstance(imported.getProject());
        return classPaths.stream()
            .map((String prefix) -> Path.of(prefix, suffix).toAbsolutePath().toString())
            .map(localFileSystem::findFileByPath)
            .filter(Objects::nonNull)
            .map(psiManager::findFile)
            .toArray(PsiElement[]::new);
    }
}
