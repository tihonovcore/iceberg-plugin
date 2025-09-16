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

public class IcebergFieldDefinitionImpl extends ASTWrapperPsiElement implements IcebergFieldDefinition {

  public IcebergFieldDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull IcebergVisitor visitor) {
    visitor.visitFieldDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof IcebergVisitor) accept((IcebergVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public IcebergExpression getExpression() {
    return findChildByClass(IcebergExpression.class);
  }

}
