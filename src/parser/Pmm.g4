grammar Pmm;	

program: definition* main EOF
;

// ####################### Parser #######################

expression: INT_CONSTANT
    | CHAR_CONSTANT
    | REAL_CONSTANT
    | ID '(' function_arguments ')'
    | ID
    | '(' expression ')'
    | expression '[' expression ']'
    | expression '.' ID
    | '(' type_simple ')' expression
    | '-' expression
    | '!' expression
    | expression ('*'|'/'|'%') expression
    | expression ('+'|'-') expression
    | expression ('>'|'>='|'<'|'=<'|'!='|'==') expression
    | expression ('&&'|'||') expression
;

statement: 'print' (expression',')* expression ';'
    | 'input' (expression',')* expression ';'
    | <assoc=right> expression '=' expression ';'
    | 'if' expression ':' body ('else'':' body | )
    | 'while' expression ':' body
    | 'return' expression ';'
    | ID '(' function_arguments ')' ';'
;

definition: function_definition
    | variable_definition
;

function_definition: 'def' ID '(' function_definition_arguments ')'':' (type_simple | ) function_body
;

main: 'def' 'main' '(' function_definition_arguments ')'':' function_body
;

/*
Function arguments refer to the arguments passed to:
    - Function invocations as expressions.
    - Function invocations as statements.

This function invocations can receive a single expression, a sequence of
expressions separated by a comma or no expressions at all.
*/
function_arguments: ((expression (',' expression)*) | )
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

function_body: '{' variable_definition* statement* '}'
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
variable_definition: ID (','ID)* ':' type_simple ';'
    | ID ':' type_complex ';'
;

type_simple: 'int'
    | 'double'
    | 'char'
;

type_complex: 'struct' '{' variable_definition* '}'
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


