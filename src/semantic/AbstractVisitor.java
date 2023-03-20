package semantic;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

public class AbstractVisitor<TP, TR> implements Visitor<TP, TR> {


    @Override
    public TR visit(Program program, TP parameter) {
        program.getDefinitions().forEach(definition -> definition.accept(this, null));
        return null;
    }

    @Override
    public TR visit(FunctionDefinition functionDefinition, TP parameter) {
        functionDefinition.getStatements().forEach(statement -> statement.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VariableDefinition variableDefinition, TP parameter) {
        return null;
    }

    @Override
    public TR visit(ArithmeticComparisonExpression arithmeticComparisonExpression, TP parameter) {
        arithmeticComparisonExpression.getLeft().accept(this, null);
        arithmeticComparisonExpression.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(ArithmeticExpression arithmeticExpression, TP parameter) {
        arithmeticExpression.getLeft().accept(this, null);
        arithmeticExpression.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(ArrayIndexExpression arrayIndexExpression, TP parameter) {
        arrayIndexExpression.getIndexer().accept(this, null);
        arrayIndexExpression.getIndexed().accept(this, null);
        return null;
    }

    @Override
    public TR visit(CastExpression castExpression, TP parameter) {
        castExpression.getExpressionToCast().accept(this, null);
        castExpression.getTargetType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(CharLiteralExpression charLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(FieldAccessExpression fieldAccessExpression, TP parameter) {
        fieldAccessExpression.getAccessed().accept(this, null);
        return null;
    }

    @Override
    public TR visit(IntLiteralExpression intLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(LogicComparisonExpression logicComparisonExpression, TP parameter) {
        logicComparisonExpression.getLeft().accept(this, null);
        logicComparisonExpression.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(NotExpression notExpression, TP parameter) {
        notExpression.getExpressionToNegate().accept(this, null);
        return null;
    }

    @Override
    public TR visit(RealLiteralExpression realLiteralExpression, TP parameter) {
        return null;
    }

    @Override
    public TR visit(UnaryMinusExpression unaryMinusExpression, TP parameter) {
        unaryMinusExpression.getExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(VariableExpression variableExpression, TP parameter) {
        variableExpression.getDefinition().accept(this, null);
        return null;
    }

    @Override
    public TR visit(FunctionInvocation functionInvocation, TP parameter) {
        functionInvocation.getArguments().forEach(expression -> expression.accept(this, null));
        functionInvocation.getVariableExpression().accept(this, null);
        return null;
    }

    @Override
    public TR visit(AssignmentStatement assignmentStatement, TP parameter) {
        assignmentStatement.getLeft().accept(this, null);
        assignmentStatement.getRight().accept(this, null);
        return null;
    }

    @Override
    public TR visit(IfElseStatement ifElseStatement, TP parameter) {
        ifElseStatement.getCondition().accept(this, null);
        ifElseStatement.getIfBody().forEach(statement -> statement.accept(this, null));
        ifElseStatement.getElseBody().forEach(statement -> statement.accept(this, null));
        return null;
    }

    @Override
    public TR visit(PrintStatement printStatement, TP parameter) {
        printStatement.getPrintExpressions().forEach(expression -> expression.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ReadStatement readStatement, TP parameter) {
        readStatement.getReadExpressions().forEach(expression -> expression.accept(this, null));
        return null;
    }

    @Override
    public TR visit(ReturnStatement returnStatement, TP parameter) {
        returnStatement.accept(this, null);
        return null;
    }

    @Override
    public TR visit(WhileStatement whileStatement, TP parameter) {
        whileStatement.getCondition().accept(this, null);
        whileStatement.getBody().forEach(statement -> statement.accept(this, null));
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
        functionType.getArguments().forEach(variableDefinition -> variableDefinition.accept(this, null));
        functionType.getReturnType().accept(this, null);
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
        recordField.getFieldType().accept(this, null);
        return null;
    }

    @Override
    public TR visit(RecordType recordType, TP parameter) {
        recordType.getFields().forEach(recordField -> recordField.accept(this, null));
        return null;
    }

    @Override
    public TR visit(VoidType voidType, TP parameter) {
        return null;
    }
}
