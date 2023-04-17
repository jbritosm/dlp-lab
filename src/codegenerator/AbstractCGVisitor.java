package codegenerator;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;
import semantic.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TR, TP> {
    @Override
    public TP visit(Program program, TR parameter) {
        return null;
    }

    @Override
    public TP visit(FunctionDefinition functionDefinition, TR parameter) {
        return null;
    }

    @Override
    public TP visit(VariableDefinition variableDefinition, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ArithmeticComparisonExpression arithmeticComparisonExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ArithmeticExpression arithmeticExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ArrayIndexExpression arrayIndexExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(CastExpression castExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(CharLiteralExpression charLiteralExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(FieldAccessExpression fieldAccessExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(IntLiteralExpression intLiteralExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(LogicComparisonExpression logicComparisonExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(NotExpression notExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(RealLiteralExpression realLiteralExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(UnaryMinusExpression unaryMinusExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(VariableExpression variableExpression, TR parameter) {
        return null;
    }

    @Override
    public TP visit(FunctionInvocation functionInvocation, TR parameter) {
        return null;
    }

    @Override
    public TP visit(AssignmentStatement assignmentStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(IfElseStatement ifElseStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(PrintStatement printStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ReadStatement readStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ReturnStatement returnStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(WhileStatement whileStatement, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ArrayType arrayType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(CharType charType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(ErrorType errorType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(FunctionType functionType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(IntType intType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(RealType realType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(RecordField recordField, TR parameter) {
        return null;
    }

    @Override
    public TP visit(RecordType recordType, TR parameter) {
        return null;
    }

    @Override
    public TP visit(VoidType voidType, TR parameter) {
        return null;
    }
}
