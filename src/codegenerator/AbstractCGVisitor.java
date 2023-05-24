package codegenerator;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;
import semantic.Visitor;

public class AbstractCGVisitor<TP, TR> implements Visitor<TP, TR> {

    protected CodeGenerator cg;
    public AbstractCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }


    @Override
    public TR visit(Program program, TP parameter) {
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP parameter) {
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ArithmeticComparisonExpression arithmeticComparisonExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ArithmeticExpression arithmeticExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ArrayIndexExpression arrayIndexExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(CastExpression castExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(CharLiteralExpression charLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(FieldAccessExpression fieldAccessExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(IntLiteralExpression intLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(LogicComparisonExpression logicComparisonExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(NotExpression notExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(RealLiteralExpression realLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(UnaryMinusExpression unaryMinusExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(VariableExpression variableExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP parameter) {
        return null;
    }

    @Override
    public TR visit(AssignmentStatement assignmentStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(IfElseStatement ifElseStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(PrintStatement printStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ReadStatement readStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ReturnStatement returnStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(WhileStatement whileStatement, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(CharType charType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(IntType intType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(RealType realType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP parameter) {
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP parameter) {
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP parameter) {
        return null;
    }
}
