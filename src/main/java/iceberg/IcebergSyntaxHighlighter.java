package iceberg;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import iceberg.psi.IcebergTokenSets;
import iceberg.psi.IcebergTypes;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class IcebergSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey ICEBERG_KEYWORD =
        createTextAttributesKey("ICEBERG_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey ICEBERG_NUMBER =
        createTextAttributesKey("ICEBERG_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey ICEBERG_OPERATOR =
        createTextAttributesKey("ICEBERG_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ICEBERG_IDENTIFIER =
        createTextAttributesKey("ICEBERG_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey ICEBERG_STRING =
        createTextAttributesKey("ICEBERG_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey ICEBERG_VALID_ESCAPE =
        createTextAttributesKey("ICEBERG_VALID_ESCAPE", DefaultLanguageHighlighterColors.VALID_STRING_ESCAPE);
    public static final TextAttributesKey ICEBERG_INVALID_ESCAPE =
        createTextAttributesKey("ICEBERG_INVALID_ESCAPE", DefaultLanguageHighlighterColors.INVALID_STRING_ESCAPE);

    public static final TextAttributesKey SEPARATOR =
        createTextAttributesKey("ICEBERG_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY =
        createTextAttributesKey("ICEBERG_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE =
        createTextAttributesKey("ICEBERG_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
        createTextAttributesKey("ICEBERG_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
        createTextAttributesKey("ICEBERG_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    {
//        var x = DefaultLanguageHighlighterColors.IDENTIFIER;
//        var x = DefaultLanguageHighlighterColors.NUMBER;
//        var x = DefaultLanguageHighlighterColors.KEYWORD;
//        var x = DefaultLanguageHighlighterColors.STRING;
//        var x = DefaultLanguageHighlighterColors.LINE_COMMENT;
//        var x = DefaultLanguageHighlighterColors.OPERATION_SIGN;
//        var x = DefaultLanguageHighlighterColors.BRACES;
//        var x = DefaultLanguageHighlighterColors.LINE_COMMENT;
//        var x = DefaultLanguageHighlighterColors.LINE_COMMENT;
    }
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{ICEBERG_KEYWORD};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{ICEBERG_NUMBER};
    private static final TextAttributesKey[] OPERATOR_KEYS = new TextAttributesKey[]{ICEBERG_OPERATOR};
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{ICEBERG_IDENTIFIER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{ICEBERG_STRING};
    private static final TextAttributesKey[] VALID_STRING_ESCAPE_KEYS = new TextAttributesKey[]{ICEBERG_VALID_ESCAPE};
    private static final TextAttributesKey[] INVALID_STRING_ESCAPE_KEYS = new TextAttributesKey[]{ICEBERG_INVALID_ESCAPE};

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new IcebergLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (IcebergTokenSets.KEYWORDS.contains(tokenType)) {
            return KEYWORD_KEYS;
        }
        if (IcebergTokenSets.OPERATORS.contains(tokenType)) {
            return OPERATOR_KEYS;
        }
        if (IcebergTypes.NUMBER.equals(tokenType)) {
            return NUMBER_KEYS;
        }
        if (IcebergTypes.ID.equals(tokenType)) {
            return IDENTIFIER_KEYS;
        }

//        if (IcebergTypes.QUOTES.equals(tokenType)) {
//            return STRING_KEYS;
//        }
        if (IcebergTypes.CHAR.equals(tokenType)) {
            return STRING_KEYS;
        }
        if (IcebergTypes.VALID_ESCAPE.equals(tokenType)) {
            return VALID_STRING_ESCAPE_KEYS;
        }
        if (IcebergTypes.INVALID_ESCAPE.equals(tokenType)) {
            return INVALID_STRING_ESCAPE_KEYS;
        }



        if (tokenType.equals(IcebergTypes.ATOM)) {
            return SEPARATOR_KEYS;
        }
        if (tokenType.equals(IcebergTypes.TRUE)) {
            return KEY_KEYS;
        }
        if (tokenType.equals(IcebergTypes.NULL)) {
            return VALUE_KEYS;
        }
        if (tokenType.equals(IcebergTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}