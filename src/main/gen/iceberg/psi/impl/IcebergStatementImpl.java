// This is a generated file. Not intended for manual editing.
package iceberg.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static iceberg.psi.IcebergTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import iceberg.psi.*;

public class IcebergStatementImpl extends ASTWrapperPsiElement implements IcebergStatement {

  public IcebergStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IcebergVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IcebergVisitor) accept((IcebergVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public IcebergBlock getBlock() {
    return findChildByClass(IcebergBlock.class);
  }

  @Override
  @Nullable
  public IcebergDefStatement getDefStatement() {
    return findChildByClass(IcebergDefStatement.class);
  }

  @Override
  @Nullable
  public IcebergExpression getExpression() {
    return findChildByClass(IcebergExpression.class);
  }

  @Override
  @Nullable
  public IcebergFunctionDefinitionStatement getFunctionDefinitionStatement() {
    return findChildByClass(IcebergFunctionDefinitionStatement.class);
  }

  @Override
  @Nullable
  public IcebergIfStatement getIfStatement() {
    return findChildByClass(IcebergIfStatement.class);
  }

  @Override
  @Nullable
  public IcebergPrintStatement getPrintStatement() {
    return findChildByClass(IcebergPrintStatement.class);
  }

  @Override
  @Nullable
  public IcebergReturnStatement getReturnStatement() {
    return findChildByClass(IcebergReturnStatement.class);
  }

  @Override
  @Nullable
  public IcebergWhileStatement getWhileStatement() {
    return findChildByClass(IcebergWhileStatement.class);
  }

}
