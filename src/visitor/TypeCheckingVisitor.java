package visitor;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

import java.lang.reflect.Array;

public class TypeCheckingVisitor implements Visitor<Void, Void> {
    @Override
        public Void visit(Program program, Void parameter) {
        program.getDefinitions().forEach(definition -> definition.accept(this, null));
        return null;
    }

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void parameter) {
        functionDefinition.getStatements().forEach(statement -> statement.accept(this, null));
        return null;
    }

    @Override
    public Void visit(VariableDefinition variableDefinition, Void parameter) {
        return null;
    }

    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Void parameter) {
        arithmeticComparisonExpression.setLValue(false);
        arithmeticComparisonExpression.getLeft().accept(this, null);
        arithmeticComparisonExpression.getRight().accept(this, null);

        return null;
    }

    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Void parameter) {
        arithmeticExpression.setLValue(false);
        arithmeticExpression.getLeft().accept(this, null);
        arithmeticExpression.getRight().accept(this, null);

        return null;
    }

    @Override
    public Void visit(ArrayIndexExpression arrayIndexExpression, Void parameter) {
        arrayIndexExpression.setLValue(true);
        arrayIndexExpression.getIndexed().accept(this, null);
        arrayIndexExpression.getIndexer().accept(this, null);

        return null;
    }

    @Override
    public Void visit(CastExpression castExpression, Void parameter) {
        castExpression.setLValue(false);
        castExpression.getExpressionToCast().accept(this, null);

        return null;
    }

    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Void parameter) {
        charLiteralExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Void parameter) {
        fieldAccessExpression.getAccessed().accept(this, null);
        fieldAccessExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Void parameter) {
        intLiteralExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(LogicComparisonExpression logicComparisonExpression, Void parameter) {
        logicComparisonExpression.getLeft().accept(this, null);
        logicComparisonExpression.getRight().accept(this, null);
        logicComparisonExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(NotExpression notExpression, Void parameter) {
        notExpression.getExpressionToNegate().accept(this, null);
        notExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Void parameter) {
        realLiteralExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(UnaryMinusExpression unaryMinusExpression, Void parameter) {
        unaryMinusExpression.getExpression().accept(this, null);
        unaryMinusExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        variableExpression.setLValue(true);

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void parameter) {
        functionInvocation.getArguments().forEach(expression -> expression.accept(this, null));
        functionInvocation.setLValue(false);

        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Void parameter) {
        assignmentStatement.getLeft().accept(this, null);
        assignmentStatement.getRight().accept(this, null);

        if(!assignmentStatement.getLeft().getLValue()) {
            new ErrorType("Required lValue in left part of assignment statement", assignmentStatement.getLeft().getLine(), assignmentStatement.getLeft().getColumn());
        }

        return null;
    }

    @Override
    public Void visit(IfElseStatement ifElseStatement, Void parameter) {
        ifElseStatement.getCondition().accept(this, null);
        ifElseStatement.getIfBody().forEach(statement -> statement.accept(this, null));
        ifElseStatement.getElseBody().forEach(statement -> statement.accept(this, null));

        return null;
    }

    @Override
    public Void visit(PrintStatement printStatement, Void parameter) {
        printStatement.getPrintExpressions().forEach(expression -> expression.accept(this, null));

        printStatement.getPrintExpressions().forEach(expression -> {
            if(!expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Void parameter) {
        readStatement.getReadExpressions().forEach(expression -> expression.accept(this, null));

        readStatement.getReadExpressions().forEach(expression -> {
            if(!expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement, Void parameter) {
        returnStatement.getReturnExpression().accept(this, null);

        return null;
    }

    @Override
    public Void visit(WhileStatement whileStatement, Void parameter) {
        whileStatement.getCondition().accept(this, null);
        whileStatement.getBody().forEach(statement -> statement.accept(this, null));

        return null;
    }

    @Override
    public Void visit(ArrayType arrayType, Void parameter) {
        arrayType.getType().accept(this, null);

        return null;
    }

    @Override
    public Void visit(CharType charType, Void parameter) {
        return null;
    }

    @Override
    public Void visit(ErrorType errorType, Void parameter) {
        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void parameter) {
        functionType.getArguments().forEach(variableDefinition -> variableDefinition.accept(this, null));
        return null;
    }

    @Override
    public Void visit(IntType intType, Void parameter) {
        return null;
    }

    @Override
    public Void visit(RealType realType, Void parameter) {
        return null;
    }

    @Override
    public Void visit(RecordField recordField, Void parameter) {
        return null;
    }

    @Override
    public Void visit(RecordType recordType, Void parameter) {
        recordType.getFields().forEach(recordField -> recordField.accept(this, null));

        return null;
    }

    @Override
    public Void visit(VoidType voidType, Void parameter) {
        return null;
    }
}
