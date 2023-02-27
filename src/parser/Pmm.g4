grammar Pmm;	

@header {
    import ast.astnode.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
}

program returns [Program ast]: definition* main EOF
;

// ####################### Parser #######################

expression returns [Expression ast]:
    ID {
                        $ast = new VariableExpression($ID.getText()
                        , $ID.getLine()
                        , $ID.getCharPositionInLine() + 1);
    } // Identifier
    | INT_CONSTANT {
                        $ast = new IntLiteralExpression(LexerHelper.lexemeToInt($INT_CONSTANT.getText())
                        , $INT_CONSTANT.getLine()
                        , $INT_CONSTANT.getCharPositionInLine() + 1);
    } // Int
    | CHAR_CONSTANT {
                        $ast = new CharLiteralExpression(LexerHelper.lexemeToChar($CHAR_CONSTANT.getText())
                        , $CHAR_CONSTANT.getLine()
                        , $CHAR_CONSTANT.getCharPositionInLine() + 1);
    } // Char
    | REAL_CONSTANT {
                        $ast = new RealLiteralExpression(LexerHelper.lexemeToReal($REAL_CONSTANT.getText))
                        , $REAL_CONSTANT.getLine()
                        , $REAL_CONSTANT.getCharPositionInLine() + 1);
    } // Double
    | ID '(' fi = function_arguments ')' {
                        $ast = new FunctionInvocation();
    } // Function invocation
    | '(' expression ')' // Parenthesis
    | expression '[' expression ']' // Array access
    | expression '.' ID // Field access
    | '(' type_simple ')' expression // Cast
    | '-' expression // Unary minus
    | '!' expression // Negation
    | expression ('*'|'/'|'%') expression // Product, Division, Modulo
    | exp1 = expression OP = ('+'|'-') exp2 = expression {
                    $ast = new ArithmeticExpression(
                    $OP.text
                    , $exp1.ast
                    , $exp2.ast
                    , $exp1.start.getLine()
                    , $exp1.start.getCharPositionInLine() + 1);
                     } // Plus, Minus Not a token but a non terminal
    | expression ('>'|'>='|'<'|'=<'|'!='|'==') expression // Arithmetic comparison
    | expression ('&&'|'||') expression // Logical comparison
;

statement: 'print' (expression',')* expression ';' // Print
    | 'input' (expression',')* expression ';' // Input
    | expression '=' expression ';' // Assignment
    | 'if' expression ':' body ('else'':' body | ) // IfElse (the else part can be epsilon)
    | 'while' expression ':' body // While
    | 'return' expression ';' // Return
    | ID '(' function_arguments ')' ';' // Function invocation
;

definition: function_definition
    | variable_definition
;

function_definition: 'def' ID '(' function_definition_arguments ')'':' (type_simple | ) function_body
;

main: 'def' 'main' '(' function_definition_arguments ')'':' function_body
;

function_body: '{' variable_definition* statement* '}'
;

/*
Function arguments refer to the arguments passed to:
    - Function invocations as expressions.
    - Function invocations as statements.

This function invocations can receive a single expression, a sequence of
expressions separated by a comma or no expressions at all.
*/
function_arguments returns[List<Expression> ast = new ArrayList<Expression>()]:
        ((exp1 = expression {
                            $ast.add($exp1);
                         }
                         (',' exp2 = expression
                            {
                                $ast.add($exp2);
                            }
                            )*)
                            | /* epsilon */ {
                                $ast = $ast;
                            })
;

/*
We can parse one argument definition, a series of argument definitions separated
by a comma or no argument definitions

Function with one argument definition:

    def p(a: int): {}

Function with a sequence of variable definitions separated by commas:

    def p(a: int, b: double): {}

Function with no argument definitions:

    def p(): {}
*/
function_definition_arguments:  (argument_definition (',' argument_definition)* | )
;

argument_definition: ID ':' type_simple
;

body: (statement | '{'statement+'}')
;

/*
In case of variable definitions we have the following possibilities:

    Just one variable definition formed by an identifier (ID) and a type
    ending with a semi-colon.
    - a: int;

    A sequence of variable definitions separated by commas ending with a
    semi-colon.
    - a: int, b: double;

    Other types of variables may be records and arrays.

    Records:
    pair: struct {
        	integer: int;
        	character: char;
    };

    Arrays:
    vector: [10][5]int;

*/
variable_definition returns [Definition ast]:
      ID {} (','ID {} )* ':' type1 = type_simple ';' {$ast = new VariableDefinition(); }
    | ID ':' type_complex ';'
;

type_simple returns [Type ast]: 'int' { $ast = new IntType().createInstance(); }
    | 'double' { $ast = new DoubleType().createInstance(); }
    | 'char' { $ast = new CharType().createInstance(); }
;

type_complex returns [Type ast]: 'struct' '{' variable_definition* '}'
    | '[' INT_CONSTANT ']' (type_simple | type_complex)
;

// ####################### Lexer #######################

fragment
DIGIT: [0-9]
;

INT_CONSTANT: '0' | [1-9]DIGIT*
;

fragment
DOT: '.'
;

fragment
EXPONENT: [eE][+-]? INT_CONSTANT
;

fragment
MANTISSA: INT_CONSTANT DOT INT_CONSTANT EXPONENT
    | INT_CONSTANT DOT EXPONENT
    | DOT INT_CONSTANT EXPONENT
    | INT_CONSTANT EXPONENT
;

REAL_CONSTANT: INT_CONSTANT DOT INT_CONSTANT
    | INT_CONSTANT DOT
    | DOT INT_CONSTANT
    | MANTISSA
;

fragment
LETTER: [a-zA-Z]
;

CHAR_CONSTANT: '\'' . '\''
    | '\'' '\\' [nt] '\''
    | '\'' '\\' INT_CONSTANT '\''
;

ID: ('_' | LETTER | DIGIT )+
;

WS: [\n\r\t ]+ -> skip
;

COMMENTS: ('#' .*? ('\n' | EOF) | '"""' .*? '"""') -> skip
;


