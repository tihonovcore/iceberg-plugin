package iceberg;

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import iceberg.psi.*;
import org.jetbrains.annotations.Nullable;

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
                    var fqn = imported.getDepIdentifierList().stream()
                        .map(PsiElement::getText)
                        .collect(Collectors.joining("."));

                    var facade = JavaPsiFacade.getInstance(sourceElement.getProject());
                    var psiClass = facade.findClass(fqn, GlobalSearchScope.allScope(sourceElement.getProject()));
                    if (psiClass != null) {
                        return new PsiElement[]{psiClass};
                    }

                    //TODO: open file from classpath
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

        //NOTE: для переменных нужен анализ скоупов
        //NOTE: для функций нужен анализ типов аргументов

        return PsiElement.EMPTY_ARRAY;
    }
}
