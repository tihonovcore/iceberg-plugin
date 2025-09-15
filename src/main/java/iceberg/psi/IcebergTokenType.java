package iceberg.psi;

import com.intellij.psi.tree.IElementType;
import iceberg.IcebergLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class IcebergTokenType extends IElementType {

    public IcebergTokenType(@NotNull @NonNls String debugName) {
        super(debugName, IcebergLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "IcebergTokenType." + super.toString();
    }
}