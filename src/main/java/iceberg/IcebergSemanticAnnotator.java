package iceberg;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import iceberg.psi.IcebergFunctionDefinitionStatement;
import iceberg.psi.IcebergVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class IcebergSemanticAnnotator extends ExternalAnnotator<List<TextRange>, List<TextRange>> {

    @Override
    public List<TextRange> collectInformation(@NotNull PsiFile file) {
        //TODO: тут можно вызвать построение IR и поймать все ошибки
        // но язык написан на Java 21, а IDEA запускается на Java 17
        // => надо переходить в языке на 17ю версию

        List<TextRange> badRanges = new ArrayList<>();
        file.accept(new IcebergVisitor() {
            boolean insideFunction = false;

            @Override
            public void visitFunctionDefinitionStatement(@NotNull IcebergFunctionDefinitionStatement o) {
                if (insideFunction) {
                    badRanges.add(o.getTextRange());
                }

                boolean prev = insideFunction;
                try {
                    insideFunction = true;
                    super.visitFunctionDefinitionStatement(o);
                } finally {
                    insideFunction = prev;
                }
            }

            @Override
            public void visitElement(@NotNull PsiElement element) {
                element.acceptChildren(this);
            }
        });

        return badRanges;
    }

    @Override
    public List<TextRange> doAnnotate(List<TextRange> collectedInfo) {
        return collectedInfo;
    }

    @Override
    public void apply(
        @NotNull PsiFile file,
        List<TextRange> annotationResult,
        @NotNull AnnotationHolder holder
    ) {
        for (var textRange : annotationResult) {
            holder.newAnnotation(HighlightSeverity.ERROR, "function inside function")
                .range(textRange)
                .create();
        }
    }
}
