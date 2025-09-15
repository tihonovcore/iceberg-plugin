package iceberg;

import com.intellij.lexer.FlexAdapter;

public class IcebergLexerAdapter extends FlexAdapter {

    public IcebergLexerAdapter() {
        super(new IcebergLexer(null));
    }
}