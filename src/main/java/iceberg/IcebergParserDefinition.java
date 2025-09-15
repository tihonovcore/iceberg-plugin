package iceberg;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import iceberg.parser.IcebergParser;
import iceberg.psi.IcebergFile;
import iceberg.psi.IcebergTokenSets;
import iceberg.psi.IcebergTypes;
import org.jetbrains.annotations.NotNull;

final class IcebergParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(IcebergLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new IcebergLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return IcebergTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new IcebergParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new IcebergFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return IcebergTypes.Factory.createElement(node);
    }
}