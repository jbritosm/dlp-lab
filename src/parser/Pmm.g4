grammar Pmm;	

@header {
    import ast.astnode.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.functioninvocation.*;
}

program returns [Program ast]: (variable_definition | function_definition)* main EOF
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
                        $ast = new RealLiteralExpression(LexerHelper.lexemeToReal($REAL_CONSTANT.getText())
                        , $REAL_CONSTANT.getLine()
                        , $REAL_CONSTANT.getCharPositionInLine() + 1);
    } // Double
    | ID '(' fi = function_arguments ')' {
                        $ast = new FunctionInvocation(
                        new VariableExpression($ID.getText(), $ID.getLine(), $ID.getCharPositionInLine() + 1)
                        , $fi.ast
                        , $ID.getLine()
                        , $ID.getCharPositionInLine() + 1
                        );
    } // Function invocation
    | '(' expression { $ast = $expression.ast; } ')' // Parenthesis
    | exp1 = expression '[' exp2 = expression ']' {
                    $ast = new ArrayIndexExpression(
                        $exp1.ast
                        , $exp2.ast
                        , $exp1.ast.getLine()
                        , $exp1.ast.getColumn());
                         } // Array access
    | expression '.' ID {
                    $ast = new FieldAccessExpression(
                    $expression.ast
                    , $ID.getText()
                    , $expression.ast.getLine()
                    , $expression.ast.getColumn());
                     } // Field access
    | '(' type_simple ')' expression {
                    $ast = new CastExpression(
                    $type_simple.ast
                    , $expression.ast
                    , $type_simple.ast.getLine()
                    , $type_simple.ast.getColumn());
                     } // Cast
    | '-' expression {
                    $ast = new UnaryMinusExpression(
                    $expression.ast
                    , $expression.ast.getLine()
                    , $expression.ast.getColumn());
                     } // Unary minus
    | '!' expression { $ast = new NotExpression($expression.ast
                    , $expression.ast.getLine()
                    , $expression.ast.getColumn());
                     } // Negation
    | exp1 = expression OP = ('*'|'/'|'%') exp2 = expression {
                      $ast = new ArithmeticExpression(
                      $OP.getText()
                      , $exp1.ast
                      , $exp2.ast
                      , $exp1.ast.getLine()
                      , $exp1.ast.getColumn());
                       } // Product, Division, Modulo
    | exp1 = expression OP = ('+'|'-') exp2 = expression {
                    $ast = new ArithmeticExpression(
                    $OP.getText()
                    , $exp1.ast
                    , $exp2.ast
                    , $exp1.ast.getLine()
                    , $exp1.ast.getColumn());
                     } // Plus, Minus Not a token but a non terminal
    | exp1 = expression OP = ('>'|'>='|'<'|'=<'|'!='|'==') exp2 = expression {
                    $ast = new ArithmeticExpression(
                    $OP.getText()
                    , $exp1.ast
                    , $exp2.ast
                    , $exp1.ast.getLine()
                    , $exp1.ast.getColumn());
                    } // Arithmetic comparison
    | exp1 = expression OP = ('&&'|'||') exp2 = expression {
                    $ast = new ArithmeticComparisonExpression(
                    $OP.getText()
                    , $exp1.ast
                    , $exp2.ast
                    , $exp1.ast.getLine()
                    , $exp1.ast.getColumn());
                    } // Logical comparison
;

statement returns [Statement ast] locals [List<Expression> exps = new ArrayList<>(), List<Statement> elseBody = new ArrayList<>()]:
    'print' exp1 = expression { $exps.add($exp1.ast); } (',' exp2 = expression { $exps.add($exp2.ast); })* ';'
     { $ast = new PrintStatement($exps, $exp1.ast.getLine(), $exp1.ast.getColumn()); } // Print
    | 'input' exp1 = expression { $exps.add($exp1.ast); } (',' exp2 = expression { $exps.add($exp2.ast); })* ';'
     { $ast = new ReadStatement($exps, $exp1.ast.getLine(), $exp1.ast.getColumn()); }// Input
    | exp1 = expression '=' exp2 = expression { $ast = new AssignmentStatement($exp1.ast, $exp2.ast, $exp1.ast.getLine(), $exp1.ast.getColumn()); } ';' // Assignment
    | IF = 'if' exp1 = expression ':' ifB = body ('else'':' elseB = body { $elseBody = $elseB.ast; } |  { $ast = $ast; } ) { $ast = new IfElseStatement($exp1.ast, $ifB.ast, $elseBody, $IF.getLine(), $IF.getCharPositionInLine() + 1); } // IfElse (the else part can be epsilon)
    | WHILE = 'while' expression ':' body { $ast = new WhileStatement($expression.ast, $body.ast, $WHILE.getLine(), $WHILE.getCharPositionInLine() + 1); } // While
    | RETURN = 'return' expression { $ast = new ReturnStatement($expression.ast, $RETURN.getLine(), $RETURN.getCharPositionInLine() + 1); } ';' // Return
    | ID '(' function_arguments ')' { $ast = new FunctionInvocation(new VariableExpression($ID.getText(), $ID.getLine(), $ID.getCharPositionInLine() + 1), $function_arguments.ast, $ID.getLine(), $ID.getCharPositionInLine() + 1); } ';' // Function invocation
;

function_definition returns[FunctionDefinition ast] locals [Type returnType]: DEF = 'def' ID '('
                    function_parameter_definition
                    ')'':'
                    ( ts = type_simple { $returnType = $ts.ast; } | vt = void_type { $returnType = $vt.ast; } )
                    function_body {
                    $ast = new FunctionDefinition(
                                            new FunctionType($function_parameter_definition.ast, $returnType),
                                            $ID.getText(),
                                            $function_body.ast,
                                            $DEF.getLine(),
                                            $DEF.getCharPositionInLine() + 1
                    );
                    }
;

main returns [FunctionDefinition ast]: DEF = 'def' MAIN = 'main' '('
                    function_parameter_definition
                    ')'':'
                    void_type
                    function_body {
                    $ast = new FunctionDefinition(
                        new FunctionType($function_parameter_definition.ast, $void_type.ast),
                        $MAIN.getText(),
                        $function_body.ast,
                        $DEF.getLine(),
                        $DEF.getCharPositionInLine() + 1
                    );
                    }
;

function_body returns [List<Statement> ast = new ArrayList<Statement>()]: '{' (varDef = variable_definition { $ast.addAll($varDef.ast); } )* ( st = statement { $ast.add($st.ast); } )* '}'
;

/*
Function arguments refer to the arguments passed to:
    - Function invocations as expressions.
    - Function invocations as statements.

This function invocations can receive a single expression, a sequence of
expressions separated by a comma or no expressions at all.
*/
function_arguments returns[List<Expression> ast = new ArrayList<Expression>()]:
        ((exp1 = expression { $ast.add($exp1.ast); }
        (',' exp2 = expression { $ast.add($exp2.ast); } )*)
        | /* epsilon */ { $ast = $ast; })
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
function_parameter_definition returns [List<VariableDefinition> ast = new ArrayList<>()]:
                    (ar1 = parameter_definition { $ast.add($ar1.ast); }
                    (',' ar2 = parameter_definition { $ast.add($ar2.ast); })*
                    | /* epsilon */ { $ast = $ast; })
;

parameter_definition returns[VariableDefinition ast]: ID ':' t1 = type_simple {
                    $ast = new VariableDefinition($t1.ast
                    , $ID.getText()
                    , $ID.getLine()
                    , $ID.getCharPositionInLine() + 1);
                     }
;

body returns [List<Statement> ast = new ArrayList<>()]:
            (st1 = statement { $ast.add($st1.ast); }
            | '{' (st2 = statement { $ast.add($st2.ast); } )+'}')
;

/*
variable_definition returns [List<VariableDefinition> ast = new ArrayList<VariableDefinition>()] locals [List<String> names = new ArrayList<>()]:
      ID1 = ID { $names.add($ID1.getText()) } (',' ID2 = ID { $names.add($ID2.getText()) } )*
      ':' t1 = type_simple
      {
        for(String name: $names) {
            $ast.add(new VariableDefinition($t1.ast, name, $ID1.getLine()))
        }
      } ';'
      | ID ':' type_complex ';'
;

type_simple returns [Type ast]: 'int' { $ast = IntType.createInstance(); }
    | 'double' { $ast = DoubleType.createInstance(); }
    | 'char' { $ast = CharType.createInstance(); }
;

type_complex returns [Type ast] locals[List<RecordField> recordFields = new ArrayList<>()]:
            'struct' '{' (rf = record_field { $recordFields.add($rf.ast) } )* '}' { $ast = new RecordType($recordFields); }
    | '[' INT_CONSTANT ']' (type_simple { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.getText())); } | type_complex)
;
*/

/*
In case of variable definitions we have the following possibilities:

    Just one variable definition formed by an identifier (ID) and a type
    ending with a semi-colon.
    - a: int;

    A sequence of variable definitions separated by commas ending with a
    semi-colon.
    - a, b: double;

    Other types of variables may be records and arrays.

    Records:
    pair: struct {
        	integer: int;
        	character: char;
    };

    Arrays:
    vector: [10][5]int;

    We do not use a single type rule because it could detect:

    a, b, c: struct {
        a: int;
    };

    a, b, c: int;

    Which is not allowed in our language.
*/
variable_definition returns [List<VariableDefinition> ast = new ArrayList<>()] locals [List<Token> identifiers = new ArrayList<>()]:
        ID1 = ID { $identifiers.add($ID1); } (',' ID2 = ID { $identifiers.add($ID2); } )*
        ':' t = type { for(Token token: $identifiers){
                            $ast.add(new VariableDefinition($t.ast, token.getText(), token.getLine(), token.getCharPositionInLine() + 1));
                       }
        } ';'
;

/*
type returns [Type ast] locals [List<RecordField> recordFields = new ArrayList<>()]: 'int' { $ast = IntType.createInstance(); }
        | 'double' { $ast = DoubleType.createInstance(); }
        | 'char' { $ast = CharType.createInstance(); }
        | '[' INT_CONSTANT ']' type { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.getText())); }
        | 'struct' '{' (rf = record_field { $recordFields.add($rf.ast) })* '}' { $ast = new RecordType($recordFields); }
;
*/

type returns [Type ast]: type_simple { $ast = $type_simple.ast; } | type_complex { $ast = $type_complex.ast; };

type_simple returns [Type ast]: 'int' { $ast = IntType.getInstance(); }
                                | 'double' { $ast = RealType.getInstance(); }
                                | 'char' { $ast = CharType.getInstance(); }
;

type_complex returns [Type ast] locals [List<RecordField> recordFields = new ArrayList<>()]:
        '[' INT_CONSTANT ']' type { $ast = new ArrayType(LexerHelper.lexemeToInt($INT_CONSTANT.getText())); }
        | 'struct' '{' (rf = record_field { $recordFields.add($rf.ast); })* '}' { $ast = new RecordType($recordFields); }
;

void_type returns [Type ast]: { $ast = VoidType.getInstance(); }
;

record_field returns [RecordField ast]: ID ':' type { $ast = new RecordField($ID.getText(), $type.ast, $ID.getLine(), $ID.getCharPositionInLine() + 1); } ';'
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


