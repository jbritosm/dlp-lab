package visitor;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

import java.io.PrintStream;

public interface Visitor<TP, TR> {

    // Program
    TR visit(Program program, TP parameter);

    // Definition
    TR visit(FunctionDefinition functionDefinition, TP parameter);
    TR visit(VariableDefinition variableDefinition, TP parameter);

    // Expressions
    TR visit(ArithmeticComparisonExpression arithmeticComparisonExpression, TP parameter);
    TR visit(ArithmeticExpression arithmeticExpression, TP parameter);
    TR visit(ArrayIndexExpression arrayIndexExpression, TP parameter);
    TR visit(CastExpression castExpression, TP parameter);
    TR visit(CharLiteralExpression charLiteralExpression, TP parameter);
    TR visit(FieldAccessExpression fieldAccessExpression, TP parameter);
    TR visit(IntLiteralExpression intLiteralExpression, TP parameter);
    TR visit(LogicComparisonExpression logicComparisonExpression, TP parameter);
    TR visit(NotExpression notExpression, TP parameter);
    TR visit(RealLiteralExpression realLiteralExpression, TP parameter);
    TR visit(UnaryMinusExpression unaryMinusExpression, TP parameter);
    TR visit(VariableExpression variableExpression, TP parameter);

    // Function invocation
    TR visit(FunctionInvocation functionInvocation, TP parameter);

    // Statement
    TR visit(AssignmentStatement assignmentStatement, TP parameter);
    TR visit(IfElseStatement ifElseStatement, TP parameter);
    TR visit(PrintStatement printStatement, TP parameter);
    TR visit(ReadStatement readStatement, TP parameter);
    TR visit(ReturnStatement returnStatement, TP parameter);
    TR visit(WhileStatement whileStatement, TP parameter);

    // Type
    TR visit(ArrayType arrayType, TP parameter);
    TR visit(CharType charType, TP parameter);
    TR visit(ErrorType errorType, TP parameter);
    TR visit(FunctionType functionType, TP parameter);
    TR visit(IntType intType, TP parameter);
    TR visit(RealType realType, TP parameter);
    TR visit(RecordField recordField, TP parameter);
    TR visit(RecordType recordType, TP parameter);
    TR visit(VoidType voidType, TP parameter);
}
