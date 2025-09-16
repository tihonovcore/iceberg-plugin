// This is a generated file. Not intended for manual editing.
package iceberg.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import iceberg.psi.impl.*;

public interface IcebergTypes {

  IElementType ADDITIVE_EXPRESSION = new IcebergElementType("ADDITIVE_EXPRESSION");
  IElementType ARGUMENTS = new IcebergElementType("ARGUMENTS");
  IElementType ATOM = new IcebergElementType("ATOM");
  IElementType BLOCK = new IcebergElementType("BLOCK");
  IElementType CLASS_DEFINITION_STATEMENT = new IcebergElementType("CLASS_DEFINITION_STATEMENT");
  IElementType DEF_STATEMENT = new IcebergElementType("DEF_STATEMENT");
  IElementType DEPENDENCY = new IcebergElementType("DEPENDENCY");
  IElementType EQUALITY_EXPRESSION = new IcebergElementType("EQUALITY_EXPRESSION");
  IElementType EXPRESSION = new IcebergElementType("EXPRESSION");
  IElementType FIELD_DEFINITION = new IcebergElementType("FIELD_DEFINITION");
  IElementType FUNCTION_CALL = new IcebergElementType("FUNCTION_CALL");
  IElementType FUNCTION_DEFINITION_STATEMENT = new IcebergElementType("FUNCTION_DEFINITION_STATEMENT");
  IElementType IF_STATEMENT = new IcebergElementType("IF_STATEMENT");
  IElementType LOGICAL_AND_EXPRESSION = new IcebergElementType("LOGICAL_AND_EXPRESSION");
  IElementType LOGICAL_OR_EXPRESSION = new IcebergElementType("LOGICAL_OR_EXPRESSION");
  IElementType MEMBER_ACCESS_EXPRESSION = new IcebergElementType("MEMBER_ACCESS_EXPRESSION");
  IElementType MULTIPLICATIVE_EXPRESSION = new IcebergElementType("MULTIPLICATIVE_EXPRESSION");
  IElementType PARAMETER = new IcebergElementType("PARAMETER");
  IElementType PARAMETERS = new IcebergElementType("PARAMETERS");
  IElementType PRINT_STATEMENT = new IcebergElementType("PRINT_STATEMENT");
  IElementType RELATIONAL_EXPRESSION = new IcebergElementType("RELATIONAL_EXPRESSION");
  IElementType RETURN_STATEMENT = new IcebergElementType("RETURN_STATEMENT");
  IElementType STATEMENT = new IcebergElementType("STATEMENT");
  IElementType UNARY_EXPRESSION = new IcebergElementType("UNARY_EXPRESSION");
  IElementType WHILE_STATEMENT = new IcebergElementType("WHILE_STATEMENT");

  IElementType AND = new IcebergTokenType("AND");
  IElementType ASSIGN = new IcebergTokenType("ASSIGN");
  IElementType CLASS = new IcebergTokenType("CLASS");
  IElementType CLOSE_BRACE = new IcebergTokenType("CLOSE_BRACE");
  IElementType CLOSE_PARENTHESIS = new IcebergTokenType("CLOSE_PARENTHESIS");
  IElementType COLON = new IcebergTokenType("COLON");
  IElementType COMMA = new IcebergTokenType("COMMA");
  IElementType COMMENT = new IcebergTokenType("COMMENT");
  IElementType DEF = new IcebergTokenType("DEF");
  IElementType DOT = new IcebergTokenType("DOT");
  IElementType ELSE = new IcebergTokenType("ELSE");
  IElementType EQ = new IcebergTokenType("EQ");
  IElementType FALSE = new IcebergTokenType("FALSE");
  IElementType FUN = new IcebergTokenType("FUN");
  IElementType GE = new IcebergTokenType("GE");
  IElementType GT = new IcebergTokenType("GT");
  IElementType ID = new IcebergTokenType("ID");
  IElementType IF = new IcebergTokenType("IF");
  IElementType IMPORT = new IcebergTokenType("IMPORT");
  IElementType LE = new IcebergTokenType("LE");
  IElementType LT = new IcebergTokenType("LT");
  IElementType MINUS = new IcebergTokenType("MINUS");
  IElementType NEQ = new IcebergTokenType("NEQ");
  IElementType NEW = new IcebergTokenType("NEW");
  IElementType NOT = new IcebergTokenType("NOT");
  IElementType NULL = new IcebergTokenType("NULL");
  IElementType NUMBER = new IcebergTokenType("NUMBER");
  IElementType OPEN_BRACE = new IcebergTokenType("OPEN_BRACE");
  IElementType OPEN_PARENTHESIS = new IcebergTokenType("OPEN_PARENTHESIS");
  IElementType OR = new IcebergTokenType("OR");
  IElementType PLUS = new IcebergTokenType("PLUS");
  IElementType PRINT = new IcebergTokenType("PRINT");
  IElementType RETURN = new IcebergTokenType("RETURN");
  IElementType SEMICOLON = new IcebergTokenType("SEMICOLON");
  IElementType SLASH = new IcebergTokenType("SLASH");
  IElementType STAR = new IcebergTokenType("STAR");
  IElementType THEN = new IcebergTokenType("THEN");
  IElementType THIS = new IcebergTokenType("THIS");
  IElementType TRUE = new IcebergTokenType("TRUE");
  IElementType WHILE = new IcebergTokenType("WHILE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_EXPRESSION) {
        return new IcebergAdditiveExpressionImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new IcebergArgumentsImpl(node);
      }
      else if (type == ATOM) {
        return new IcebergAtomImpl(node);
      }
      else if (type == BLOCK) {
        return new IcebergBlockImpl(node);
      }
      else if (type == CLASS_DEFINITION_STATEMENT) {
        return new IcebergClassDefinitionStatementImpl(node);
      }
      else if (type == DEF_STATEMENT) {
        return new IcebergDefStatementImpl(node);
      }
      else if (type == DEPENDENCY) {
        return new IcebergDependencyImpl(node);
      }
      else if (type == EQUALITY_EXPRESSION) {
        return new IcebergEqualityExpressionImpl(node);
      }
      else if (type == EXPRESSION) {
        return new IcebergExpressionImpl(node);
      }
      else if (type == FIELD_DEFINITION) {
        return new IcebergFieldDefinitionImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new IcebergFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DEFINITION_STATEMENT) {
        return new IcebergFunctionDefinitionStatementImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new IcebergIfStatementImpl(node);
      }
      else if (type == LOGICAL_AND_EXPRESSION) {
        return new IcebergLogicalAndExpressionImpl(node);
      }
      else if (type == LOGICAL_OR_EXPRESSION) {
        return new IcebergLogicalOrExpressionImpl(node);
      }
      else if (type == MEMBER_ACCESS_EXPRESSION) {
        return new IcebergMemberAccessExpressionImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPRESSION) {
        return new IcebergMultiplicativeExpressionImpl(node);
      }
      else if (type == PARAMETER) {
        return new IcebergParameterImpl(node);
      }
      else if (type == PARAMETERS) {
        return new IcebergParametersImpl(node);
      }
      else if (type == PRINT_STATEMENT) {
        return new IcebergPrintStatementImpl(node);
      }
      else if (type == RELATIONAL_EXPRESSION) {
        return new IcebergRelationalExpressionImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new IcebergReturnStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new IcebergStatementImpl(node);
      }
      else if (type == UNARY_EXPRESSION) {
        return new IcebergUnaryExpressionImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new IcebergWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
