// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import iceberg.psi.impl.*;

public interface IcebergTypes {

  IElementType ATOM = new IcebergElementType("ATOM");
  IElementType DEPENDENCY = new IcebergElementType("DEPENDENCY");
  IElementType EXPRESSION = new IcebergElementType("EXPRESSION");
  IElementType FACTOR = new IcebergElementType("FACTOR");
  IElementType PRINT_STATEMENT = new IcebergElementType("PRINT_STATEMENT");
  IElementType STATEMENT = new IcebergElementType("STATEMENT");
  IElementType TERM = new IcebergElementType("TERM");

  IElementType COMMENT = new IcebergTokenType("COMMENT");
  IElementType DOT = new IcebergTokenType("DOT");
  IElementType FALSE = new IcebergTokenType("FALSE");
  IElementType ID = new IcebergTokenType("ID");
  IElementType IMPORT = new IcebergTokenType("IMPORT");
  IElementType MINUS = new IcebergTokenType("MINUS");
  IElementType NULL = new IcebergTokenType("NULL");
  IElementType NUMBER = new IcebergTokenType("NUMBER");
  IElementType PLUS = new IcebergTokenType("PLUS");
  IElementType PRINT = new IcebergTokenType("PRINT");
  IElementType SEMICOLON = new IcebergTokenType("SEMICOLON");
  IElementType SLASH = new IcebergTokenType("SLASH");
  IElementType STAR = new IcebergTokenType("STAR");
  IElementType TRUE = new IcebergTokenType("TRUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOM) {
        return new IcebergAtomImpl(node);
      }
      else if (type == DEPENDENCY) {
        return new IcebergDependencyImpl(node);
      }
      else if (type == EXPRESSION) {
        return new IcebergExpressionImpl(node);
      }
      else if (type == FACTOR) {
        return new IcebergFactorImpl(node);
      }
      else if (type == PRINT_STATEMENT) {
        return new IcebergPrintStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new IcebergStatementImpl(node);
      }
      else if (type == TERM) {
        return new IcebergTermImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
