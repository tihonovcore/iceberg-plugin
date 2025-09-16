// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface IcebergStatement extends PsiElement {

  @Nullable
  IcebergBlock getBlock();

  @Nullable
  IcebergClassDefinitionStatement getClassDefinitionStatement();

  @Nullable
  IcebergDefStatement getDefStatement();

  @Nullable
  IcebergExpression getExpression();

  @Nullable
  IcebergFunctionDefinitionStatement getFunctionDefinitionStatement();

  @Nullable
  IcebergIfStatement getIfStatement();

  @Nullable
  IcebergPrintStatement getPrintStatement();

  @Nullable
  IcebergReturnStatement getReturnStatement();

  @Nullable
  IcebergWhileStatement getWhileStatement();

}
