package iceberg.psi;

import com.intellij.psi.tree.TokenSet;

public interface IcebergTokenSets {

    TokenSet KEYWORDS = TokenSet.create(
        IcebergTypes.PRINT,
        IcebergTypes.WHILE,
        IcebergTypes.IF,
        IcebergTypes.THEN,
        IcebergTypes.ELSE,
        IcebergTypes.FUN,
        IcebergTypes.RETURN,
        IcebergTypes.IMPORT, //TODO: cmd+b в джаву
        IcebergTypes.FALSE,
        IcebergTypes.TRUE,
        IcebergTypes.DEF
    );

    TokenSet OPERATORS = TokenSet.create(
        IcebergTypes.PLUS,
        IcebergTypes.MINUS,
        IcebergTypes.STAR,
        IcebergTypes.SLASH,
        IcebergTypes.EQ,
        IcebergTypes.NEQ,
        IcebergTypes.LE,
        IcebergTypes.GE,
        IcebergTypes.LT,
        IcebergTypes.GT,
        IcebergTypes.AND,
        IcebergTypes.OR
    );

    TokenSet COMMENTS = TokenSet.create(IcebergTypes.COMMENT);
}