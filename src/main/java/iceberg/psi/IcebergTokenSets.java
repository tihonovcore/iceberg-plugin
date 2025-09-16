package iceberg.psi;

import com.intellij.psi.tree.TokenSet;

public interface IcebergTokenSets {

    TokenSet KEYWORDS = TokenSet.create(
        IcebergTypes.PRINT,
        IcebergTypes.IMPORT, //TODO: cmd+b в джаву
        IcebergTypes.FALSE,
        IcebergTypes.TRUE
    );

    TokenSet OPERATORS = TokenSet.create(
        IcebergTypes.PLUS,
        IcebergTypes.MINUS,
        IcebergTypes.STAR,
        IcebergTypes.SLASH
    );

    TokenSet COMMENTS = TokenSet.create(IcebergTypes.COMMENT);
}