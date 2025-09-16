// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package iceberg;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import iceberg.psi.IcebergTypes;

%%

%class IcebergLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

PLUS  = "+"
MINUS = "-"
STAR  = "*"
SLASH = "/"
//OPEN_PARENTHESIS  : '(';
//CLOSE_PARENTHESIS : ')';
//OPEN_BRACE        : '{';
//CLOSE_BRACE       : '}';
//
//EQ : '==';
//NEQ : '!=';
//
//LE : '<=';
//GE : '>=';
//LT : '<';
//GT : '>';
//
//NOT : 'not';
//AND : 'and';
//OR  : 'or';

PRINT  = print
//WHILE  : 'while';
//IF     : 'if';
//THEN   : 'then';
//ELSE   : 'else';
//FUN    : 'fun';
//RETRUN : 'return';
//CLASS  : 'class';
//NEW    : 'new';
//THIS   : 'this';
IMPORT = import

NUMBER = 0 | -? [1-9][0-9]*
FALSE  = false
TRUE   = true
NULL   = null

//DEF    : 'def';
//COLON  : ':';
//ASSIGN : '=';
ID     = [A-Za-z_][A-Za-z_0-9]*
DOT    = "."

//STRING
//  : '"' (ESCAPE | CHAR)* '"'
//  ;
//fragment ESCAPE
//  : '\\"'
//  | '\\n'
//  ;
//fragment CHAR
//  : ~ ["\\]
//  ;

SEMICOLON = ;
COMMA     = ,

WS      = [ \n\t\r]+
COMMENT = "//" [^\n\r]*

%%

<YYINITIAL> {PLUS}                            { return IcebergTypes.PLUS; }
<YYINITIAL> {MINUS}                           { return IcebergTypes.MINUS; }
<YYINITIAL> {STAR}                            { return IcebergTypes.STAR; }
<YYINITIAL> {SLASH}                           { return IcebergTypes.SLASH; }

<YYINITIAL> {PRINT}                           { return IcebergTypes.PRINT; }
<YYINITIAL> {IMPORT}                          { return IcebergTypes.IMPORT; }

<YYINITIAL> {NUMBER}                          { return IcebergTypes.NUMBER; }
<YYINITIAL> {FALSE}                           { return IcebergTypes.FALSE; }
<YYINITIAL> {TRUE}                            { return IcebergTypes.TRUE; }
<YYINITIAL> {NULL}                            { return IcebergTypes.NULL; }

<YYINITIAL> {ID}                              { return IcebergTypes.ID; }
<YYINITIAL> {DOT}                             { return IcebergTypes.DOT; }

<YYINITIAL> {SEMICOLON}                       { return IcebergTypes.SEMICOLON; }
//<YYINITIAL> {COMMA}                           { return IcebergTypes.COMMA; }

<YYINITIAL> {COMMENT}                         { return IcebergTypes.COMMENT; }
<YYINITIAL> {WS}                              { return TokenType.WHITE_SPACE; }

[^]                                           { return TokenType.BAD_CHARACTER; }