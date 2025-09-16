// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class IcebergVisitor extends PsiElementVisitor {

  public void visitAtom(@NotNull IcebergAtom o) {
    visitPsiElement(o);
  }

  public void visitDependency(@NotNull IcebergDependency o) {
    visitPsiElement(o);
  }

  public void visitExpression(@NotNull IcebergExpression o) {
    visitPsiElement(o);
  }

  public void visitFactor(@NotNull IcebergFactor o) {
    visitPsiElement(o);
  }

  public void visitPrintStatement(@NotNull IcebergPrintStatement o) {
    visitPsiElement(o);
  }

  public void visitStatement(@NotNull IcebergStatement o) {
    visitPsiElement(o);
  }

  public void visitTerm(@NotNull IcebergTerm o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
