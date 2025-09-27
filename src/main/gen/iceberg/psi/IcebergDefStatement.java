// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IcebergDefStatement extends PsiElement {

  @Nullable
  IcebergClassReference getClassReference();

  @Nullable
  IcebergExpression getExpression();

  @NotNull
  IcebergVarIdentifier getVarIdentifier();

}
