package iceberg;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.ProcessingContext;
import iceberg.psi.IcebergTokenSets;
import iceberg.psi.IcebergTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.stream.Stream;

final class IcebergCompletionContributor extends CompletionContributor {

    IcebergCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(IcebergTypes.ID),
            new CompletionProvider<>() {
                public void addCompletions(
                    @NotNull CompletionParameters parameters,
                    @NotNull ProcessingContext context,
                    @NotNull CompletionResultSet resultSet
                ) {
                    Arrays.stream(IcebergTokenSets.KEYWORDS.getTypes())
                        .map(IElementType::getDebugName)
                        .map(String::toLowerCase)
                        .map(keyword -> keyword + " ")
                        .filter(resultSet.getPrefixMatcher()::prefixMatches)
                        .forEach(keyword -> resultSet.addElement(LookupElementBuilder.create(keyword)));

                    Stream.of("bool", "i32", "i64", "unit", "string")
                        .map(icebergType -> icebergType + " ")
                        .filter(resultSet.getPrefixMatcher()::prefixMatches)
                        .forEach(keyword -> resultSet.addElement(LookupElementBuilder.create(keyword)));
                }
            }
        );
    }
}