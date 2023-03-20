package semantic;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Void> {

    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Void parameter) {
        arithmeticComparisonExpression.setLValue(false);
        super.visit(arithmeticComparisonExpression, null);

        return null;
    }

    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Void parameter) {
        arithmeticExpression.setLValue(false);
        super.visit(arithmeticExpression, null);

        return null;
    }

    @Override
    public Void visit(ArrayIndexExpression arrayIndexExpression, Void parameter) {
        arrayIndexExpression.setLValue(true);
        super.visit(arrayIndexExpression, null);

        return null;
    }

    @Override
    public Void visit(CastExpression castExpression, Void parameter) {
        castExpression.setLValue(false);
        super.visit(castExpression, null);

        return null;
    }

    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Void parameter) {
        charLiteralExpression.setLValue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Void parameter) {
        fieldAccessExpression.setLValue(false);
        super.visit(fieldAccessExpression, null);

        return null;
    }

    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Void parameter) {
        intLiteralExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(LogicComparisonExpression logicComparisonExpression, Void parameter) {
        logicComparisonExpression.setLValue(false);
        super.visit(logicComparisonExpression, null);

        return null;
    }

    @Override
    public Void visit(NotExpression notExpression, Void parameter) {
        notExpression.setLValue(false);
        super.visit(notExpression, null);

        return null;
    }

    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Void parameter) {
        realLiteralExpression.setLValue(false);

        return null;
    }

    @Override
    public Void visit(UnaryMinusExpression unaryMinusExpression, Void parameter) {
        unaryMinusExpression.setLValue(false);
        super.visit(unaryMinusExpression, null);

        return null;
    }

    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        variableExpression.setLValue(true);

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void parameter) {
        functionInvocation.setLValue(false);
        super.visit(functionInvocation, null);

        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Void parameter) {
        super.visit(assignmentStatement, null);

        if(!assignmentStatement.getLeft().getLValue()) {
            new ErrorType("Required lValue in left part of assignment statement", assignmentStatement.getLeft().getLine(), assignmentStatement.getLeft().getColumn());
        }

        return null;
    }

    @Override
    public Void visit(PrintStatement printStatement, Void parameter) {
        super.visit(printStatement, null);

        printStatement.getPrintExpressions().forEach(expression -> {
            if(!expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Void parameter) {
        super.visit(readStatement, null);

        readStatement.getReadExpressions().forEach(expression -> {
            if(!expression.getLValue())
                new ErrorType("Required lValue in left part of assignment statement", expression.getLine(), expression.getColumn());
        });

        return null;
    }
}
