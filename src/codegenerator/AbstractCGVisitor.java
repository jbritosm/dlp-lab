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
        throwException("Program");
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP parameter) {
        throwException("FunctionDefinition");
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP parameter) {
        throwException("VariableDefinition");
        return null;
    }

    @Override
    public TR visit(ArithmeticComparisonExpression arithmeticComparisonExpression, TP parameter) {
        throwException("ArithmeticComparisonExpression");
        return null;
    }

    @Override
    public TR visit(ArithmeticExpression arithmeticExpression, TP parameter) {
        throwException("ArithmeticExpression");
        return null;
    }

    @Override
    public TR visit(ArrayIndexExpression arrayIndexExpression, TP parameter) {
        throwException("ArrayIndexExpression");
        return null;
    }

    @Override
    public TR visit(CastExpression castExpression, TP parameter) {
        throwException("CastExpression");
        return null;
    }

    @Override
    public TR visit(CharLiteralExpression charLiteralExpression, TP parameter) {
        throwException("CharLiteralExpression");
        return null;
    }

    @Override
    public TR visit(FieldAccessExpression fieldAccessExpression, TP parameter) {
        throwException("FieldAccessExpression");
        return null;
    }

    @Override
    public TR visit(IntLiteralExpression intLiteralExpression, TP parameter) {
        throwException("IntLiteralExpression");
        return null;
    }

    @Override
    public TR visit(LogicComparisonExpression logicComparisonExpression, TP parameter) {
        throwException("LogicComparisonExpression");
        return null;
    }

    @Override
    public TR visit(NotExpression notExpression, TP parameter) {
        throwException("NotExpression");
        return null;
    }

    @Override
    public TR visit(RealLiteralExpression realLiteralExpression, TP parameter) {
        throwException("RealLiteralExpression");
        return null;
    }

    @Override
    public TR visit(UnaryMinusExpression unaryMinusExpression, TP parameter) {
        throwException("UnaryMinusExpression");
        return null;
    }

    @Override
    public TR visit(VariableExpression variableExpression, TP parameter) {
        throwException("VariableExpression");
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP parameter) {
        throwException("FunctionInvocation");
        return null;
    }

    @Override
    public TR visit(AssignmentStatement assignmentStatement, TP parameter) {
        throwException("AssignmentStatement");
        return null;    }

    @Override
    public TR visit(IfElseStatement ifElseStatement, TP parameter) {
        throwException("IfElseStatement");
        return null;
    }

    @Override
    public TR visit(PrintStatement printStatement, TP parameter) {
        throwException("PrintStatement");
        return null;
    }

    @Override
    public TR visit(ReadStatement readStatement, TP parameter) {
        throwException("ReadStatement");
        return null;
    }

    @Override
    public TR visit(ReturnStatement returnStatement, TP parameter) {
        throwException("ReturnStatement");
        return null;
    }

    @Override
    public TR visit(WhileStatement whileStatement, TP parameter) {
        throwException("WhileStatement");
        return null;
    }

    @Override
    public TR visit(ArrayType arrayType, TP parameter) {
        throwException("ArrayType");
        return null;
    }

    @Override
    public TR visit(CharType charType, TP parameter) {
        throwException("CharType");
        return null;
    }

    @Override
    public TR visit(ErrorType errorType, TP parameter) {
        throwException("ErrorType");
        return null;
    }

    @Override
    public TR visit(FunctionType functionType, TP parameter) {
        throwException("FunctionType");
        return null;
    }

    @Override
    public TR visit(IntType intType, TP parameter) {
        throwException("IntType");
        return null;
    }

    @Override
    public TR visit(RealType realType, TP parameter) {
        throwException("RealType");
        return null;
    }

    @Override
    public TR visit(RecordField recordField, TP parameter) {
        throwException("RecordField");
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP parameter) {
        throwException("RecordType");
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP parameter) {
        throwException("VoidType");
        return null;
    }

    private void throwException(String arg) {
        throw new IllegalStateException(String.format("Cannot generate code for %s.", arg));
    }
}
