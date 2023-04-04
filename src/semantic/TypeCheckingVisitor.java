package semantic;

import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Void parameter) {
        super.visit(arithmeticComparisonExpression, null);
        arithmeticComparisonExpression.setLValue(false);



        return null;
    }

    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Void parameter) {
        super.visit(arithmeticExpression, null);
        arithmeticExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(ArrayIndexExpression arrayIndexExpression, Void parameter) {
        super.visit(arrayIndexExpression, null);
        arrayIndexExpression.setLValue(true);
        return null;
    }

    @Override
    public Void visit(CastExpression castExpression, Void parameter) {
        super.visit(castExpression, null);
        castExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Void parameter) {
        charLiteralExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Void parameter) {
        super.visit(fieldAccessExpression, null);
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
        super.visit(logicComparisonExpression, null);
        logicComparisonExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(NotExpression notExpression, Void parameter) {
        super.visit(notExpression, null);
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
        super.visit(unaryMinusExpression, null);
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
        super.visit(functionInvocation, null);
        functionInvocation.setLValue(false);
        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Void parameter) {
        super.visit(assignmentStatement, null);

        if(assignmentStatement.getLeft().getLValue()) {
            new ErrorType("Required lValue in left part of assignment statement", assignmentStatement.getLeft().getLine(), assignmentStatement.getLeft().getColumn());
        }

        return null;
    }

    @Override
    public Void visit(PrintStatement printStatement, Void parameter) {
        super.visit(printStatement, null);

        printStatement.getPrintExpressions().forEach(expression -> {
            if(expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Void parameter) {
        super.visit(readStatement, null);

        readStatement.getReadExpressions().forEach(expression -> {
            if(expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }
}
