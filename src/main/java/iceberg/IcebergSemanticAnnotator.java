package iceberg;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.ExternalAnnotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiFile;
import iceberg.common.Analyzer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

import static iceberg.IcebergSemanticAnnotator.*;

public class IcebergSemanticAnnotator extends ExternalAnnotator<List<Info>, List<Info>> {

    public record Info(TextRange textRange, String message) {}

    @Override
    public List<Info> collectInformation(@NotNull PsiFile file) {
        try {
            new Analyzer().analyze(file.getText());
        } catch (CompilationException e) {
            //ignore, it's processed by PSI
        }catch (SemanticException e) {
            if (0 <= e.start && e.start <= e.stop) {
                var textRange = new TextRange(e.start, e.stop);
                return List.of(new Info(textRange, e.getMessage()));
            }
        }

        return Collections.emptyList();
    }

    @Override
    public @Nullable List<Info> doAnnotate(List<Info> collectedInfo) {
        return collectedInfo;
    }

    @Override
    public void apply(
        @NotNull PsiFile file,
        List<Info> annotationResult,
        @NotNull AnnotationHolder holder
    ) {
        for (var info : annotationResult) {
            holder.newAnnotation(HighlightSeverity.ERROR, info.message)
                .range(info.textRange)
                .create();
        }
    }
}
