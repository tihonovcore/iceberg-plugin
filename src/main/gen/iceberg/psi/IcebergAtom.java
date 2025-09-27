// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IcebergAtom extends PsiElement {

  @Nullable
  IcebergExpression getExpression();

  @Nullable
  IcebergFunctionCall getFunctionCall();

  @Nullable
  IcebergVarReference getVarReference();

}
