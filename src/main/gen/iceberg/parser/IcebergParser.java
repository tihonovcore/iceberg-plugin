// This is a generated file. Not intended for manual editing.
package iceberg.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static iceberg.psi.IcebergTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class IcebergParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return file(b, l + 1);
  }

  /* ********************************************************** */
  // multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*
  public static boolean additiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_EXPRESSION, "<additive expression>");
    r = multiplicativeExpression(b, l + 1);
    r = r && additiveExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((PLUS | MINUS) multiplicativeExpression)*
  private static boolean additiveExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additiveExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveExpression_1", c)) break;
    }
    return true;
  }

  // (PLUS | MINUS) multiplicativeExpression
  private static boolean additiveExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveExpression_1_0_0(b, l + 1);
    r = r && multiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean additiveExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // NUMBER|FALSE|TRUE|NULL|COMMENT|ID
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, ID);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DEF ID
  //   ( COLON ID (ASSIGN expression)?
  //   | ASSIGN expression
  //   )
  public static boolean defStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement")) return false;
    if (!nextTokenIs(b, DEF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DEF, ID);
    r = r && defStatement_2(b, l + 1);
    exit_section_(b, m, DEF_STATEMENT, r);
    return r;
  }

  // COLON ID (ASSIGN expression)?
  //   | ASSIGN expression
  private static boolean defStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = defStatement_2_0(b, l + 1);
    if (!r) r = defStatement_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON ID (ASSIGN expression)?
  private static boolean defStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, ID);
    r = r && defStatement_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN expression)?
  private static boolean defStatement_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement_2_0_2")) return false;
    defStatement_2_0_2_0(b, l + 1);
    return true;
  }

  // ASSIGN expression
  private static boolean defStatement_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ASSIGN expression
  private static boolean defStatement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defStatement_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT ID (DOT ID)* SEMICOLON
  public static boolean dependency(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dependency")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, ID);
    r = r && dependency_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DEPENDENCY, r);
    return r;
  }

  // (DOT ID)*
  private static boolean dependency_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dependency_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dependency_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dependency_2", c)) break;
    }
    return true;
  }

  // DOT ID
  private static boolean dependency_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dependency_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // relationalExpression     ((EQ | NEQ) relationalExpression)*
  public static boolean equalityExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUALITY_EXPRESSION, "<equality expression>");
    r = relationalExpression(b, l + 1);
    r = r && equalityExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((EQ | NEQ) relationalExpression)*
  private static boolean equalityExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!equalityExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equalityExpression_1", c)) break;
    }
    return true;
  }

  // (EQ | NEQ) relationalExpression
  private static boolean equalityExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equalityExpression_1_0_0(b, l + 1);
    r = r && relationalExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQ | NEQ
  private static boolean equalityExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NEQ);
    return r;
  }

  /* ********************************************************** */
  // logicalOrExpression      (ASSIGN logicalOrExpression)?
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION, "<expression>");
    r = logicalOrExpression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN logicalOrExpression)?
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    expression_1_0(b, l + 1);
    return true;
  }

  // ASSIGN logicalOrExpression
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && logicalOrExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dependency* statement*
  static boolean file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = file_0(b, l + 1);
    r = r && file_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // dependency*
  private static boolean file_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dependency(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_0", c)) break;
    }
    return true;
  }

  // statement*
  private static boolean file_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IF expression
  //       THEN statement
  //       (ELSE statement)?
  public static boolean ifStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && statement(b, l + 1);
    r = r && ifStatement_4(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // (ELSE statement)?
  private static boolean ifStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_4")) return false;
    ifStatement_4_0(b, l + 1);
    return true;
  }

  // ELSE statement
  private static boolean ifStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // equalityExpression       (AND equalityExpression)*
  public static boolean logicalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_AND_EXPRESSION, "<logical and expression>");
    r = equalityExpression(b, l + 1);
    r = r && logicalAndExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (AND equalityExpression)*
  private static boolean logicalAndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalAndExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalAndExpression_1", c)) break;
    }
    return true;
  }

  // AND equalityExpression
  private static boolean logicalAndExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AND);
    r = r && equalityExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logicalAndExpression     (OR logicalAndExpression)*
  public static boolean logicalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OR_EXPRESSION, "<logical or expression>");
    r = logicalAndExpression(b, l + 1);
    r = r && logicalOrExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (OR logicalAndExpression)*
  private static boolean logicalOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalOrExpression_1", c)) break;
    }
    return true;
  }

  // OR logicalAndExpression
  private static boolean logicalOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OR);
    r = r && logicalAndExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unaryExpression
  public static boolean memberAccessExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "memberAccessExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MEMBER_ACCESS_EXPRESSION, "<member access expression>");
    r = unaryExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // memberAccessExpression   ((STAR | SLASH) memberAccessExpression)*
  public static boolean multiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_EXPRESSION, "<multiplicative expression>");
    r = memberAccessExpression(b, l + 1);
    r = r && multiplicativeExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((STAR | SLASH) memberAccessExpression)*
  private static boolean multiplicativeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicativeExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpression_1", c)) break;
    }
    return true;
  }

  // (STAR | SLASH) memberAccessExpression
  private static boolean multiplicativeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeExpression_1_0_0(b, l + 1);
    r = r && memberAccessExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR | SLASH
  private static boolean multiplicativeExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, SLASH);
    return r;
  }

  /* ********************************************************** */
  // PRINT expression
  public static boolean printStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printStatement")) return false;
    if (!nextTokenIs(b, PRINT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PRINT);
    r = r && expression(b, l + 1);
    exit_section_(b, m, PRINT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // additiveExpression       ((LT | LE | GT | GE) additiveExpression)*
  public static boolean relationalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_EXPRESSION, "<relational expression>");
    r = additiveExpression(b, l + 1);
    r = r && relationalExpression_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LT | LE | GT | GE) additiveExpression)*
  private static boolean relationalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!relationalExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationalExpression_1", c)) break;
    }
    return true;
  }

  // (LT | LE | GT | GE) additiveExpression
  private static boolean relationalExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationalExpression_1_0_0(b, l + 1);
    r = r && additiveExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT | LE | GT | GE
  private static boolean relationalExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    return r;
  }

  /* ********************************************************** */
  // expression     SEMICOLON
  //     | printStatement SEMICOLON
  //     | defStatement   SEMICOLON
  //     | ifStatement
  //     | whileStatement
  //     | COMMENT
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    if (!r) r = ifStatement(b, l + 1);
    if (!r) r = whileStatement(b, l + 1);
    if (!r) r = consumeToken(b, COMMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expression     SEMICOLON
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // printStatement SEMICOLON
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = printStatement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  // defStatement   SEMICOLON
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = defStatement(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom
  public static boolean unaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // WHILE expression THEN statement
  public static boolean whileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && statement(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

}
