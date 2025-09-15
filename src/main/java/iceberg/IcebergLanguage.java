package iceberg;

import com.intellij.lang.Language;

public class IcebergLanguage extends Language {

    public static final IcebergLanguage INSTANCE = new IcebergLanguage();

    private IcebergLanguage() {
        super("Iceberg");
    }
}
