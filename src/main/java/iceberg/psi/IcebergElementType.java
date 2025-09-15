package iceberg.psi;

import com.intellij.psi.tree.IElementType;
import iceberg.IcebergLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IcebergElementType extends IElementType {

    public IcebergElementType(@NotNull @NonNls String debugName) {
        super(debugName, IcebergLanguage.INSTANCE);
    }
}