package iceberg.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import iceberg.IcebergFileType;
import iceberg.IcebergLanguage;
import org.jetbrains.annotations.NotNull;

public class IcebergFile extends PsiFileBase {

    public IcebergFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, IcebergLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return IcebergFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Iceberg File";
    }
}