package iceberg;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class IcebergFileType extends LanguageFileType {

    public static final IcebergFileType INSTANCE = new IcebergFileType();

    private IcebergFileType() {
        super(IcebergLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Iceberg File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Iceberg language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return ".ib";
    }

    @Override
    public Icon getIcon() {
        return IcebergIcons.FILE;
    }
}