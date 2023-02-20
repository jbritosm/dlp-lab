grammar Pmm;	

program: expression EOF
;

// ####################### Parser #######################

expression: INT_CONSTANT
    | CHAR_CONSTANT
    | REAL_CONSTANT
    | ID '(' (((expression',')* expression) | )')'
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
    | expression '=' expression ';'
    | 'if' expression ':' body ('else'':' body | )
;

body: (statement | ('{'statement+'}')) ';'
;

variable_definition: (ID',')* ID ':' (type_simple | type_complex) ';'
;

type_simple: 'int'
    | 'double'
    | 'char'
;

type_complex: 'struct' '{' variable_definition* '}'
    | '[' INT_CONSTANT ']' type_simple
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


