package semantic;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TypeCheckingVisitor extends AbstractVisitor<Type, Void> {

    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Type parameter) {
        super.visit(arithmeticComparisonExpression, null);
        arithmeticComparisonExpression.setLValue(false);

        arithmeticComparisonExpression.setType(
                arithmeticComparisonExpression.getLeft().getType().asLogical(
                        arithmeticComparisonExpression.getRight().getType()
                        , arithmeticComparisonExpression
                ));



        return null;
    }

    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Type parameter) {
        super.visit(arithmeticExpression, null);
        arithmeticExpression.setLValue(false);

        arithmeticExpression.setType(
                arithmeticExpression.getLeft().getType().asArithmetic(
                        arithmeticExpression.getRight().getType()
                        , arithmeticExpression
                ));



        return null;
    }

    @Override
    public Void visit(ArrayIndexExpression arrayIndexExpression, Type parameter) {
        super.visit(arrayIndexExpression, null);
        arrayIndexExpression.setLValue(true);

        arrayIndexExpression.setType(
                arrayIndexExpression.getIndexed().getType().squareBrackets(
                        arrayIndexExpression.getIndexer().getType()
                        , arrayIndexExpression
                ));

        return null;
    }

    @Override
    public Void visit(CastExpression castExpression, Type parameter) {
        super.visit(castExpression, null);
        castExpression.setLValue(false);

        castExpression.setType(
                castExpression.getExpressionToCast().getType().castTo(
                        castExpression.getTargetType()
                        , castExpression
                ));



        return null;
    }

    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Type parameter) {
        charLiteralExpression.setLValue(false);

        charLiteralExpression.setType(CharType.getInstance());

        return null;
    }

    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Type parameter) {
        super.visit(fieldAccessExpression, null);
        // TODO Set to true because nums.a = 2;
        fieldAccessExpression.setLValue(true);

        fieldAccessExpression.setType(
                fieldAccessExpression.getAccessed().getType().dot(
                        fieldAccessExpression.getName()
                        , fieldAccessExpression
                ));

        return null;
    }

    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Type parameter) {
        intLiteralExpression.setLValue(false);

        intLiteralExpression.setType(IntType.getInstance());

        return null;
    }

    @Override
    public Void visit(LogicComparisonExpression logicComparisonExpression, Type parameter) {
        super.visit(logicComparisonExpression, null);
        logicComparisonExpression.setLValue(false);

        logicComparisonExpression.setType(
                logicComparisonExpression.getLeft().getType().asLogical(
                        logicComparisonExpression.getRight().getType()
                        , logicComparisonExpression
                ));

        return null;
    }

    @Override
    public Void visit(NotExpression notExpression, Type parameter) {
        super.visit(notExpression, null);
        notExpression.setLValue(false);

        notExpression.setType(
                notExpression.getExpressionToNegate().getType().asNegation(
                        notExpression
                ));

        return null;
    }

    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Type parameter) {
        realLiteralExpression.setLValue(false);

        realLiteralExpression.setType(RealType.getInstance());

        return null;
    }

    @Override
    public Void visit(UnaryMinusExpression unaryMinusExpression, Type parameter) {
        super.visit(unaryMinusExpression, null);
        unaryMinusExpression.setLValue(false);

        unaryMinusExpression.setType(
                unaryMinusExpression.getExpression().getType().asUnaryMinus(
                        unaryMinusExpression
                ));

        return null;
    }

    @Override
    public Void visit(VariableExpression variableExpression, Type parameter) {
        super.visit(variableExpression, null);
        variableExpression.setLValue(true);

        variableExpression.setType(variableExpression.getDefinition().getType());

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Type parameter) {
        super.visit(functionInvocation, null);
        functionInvocation.setLValue(false);

        List<Type> argumentTypes = functionInvocation.getArguments().stream().map(Expression::getType).toList();

        functionInvocation.setType(functionInvocation.getVariableExpression().getType().checkArgumentTypes(argumentTypes, functionInvocation));

        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Type parameter) {
        super.visit(assignmentStatement, null);
        // TODO If set to true the following is allowed a = b = c;

        if(!assignmentStatement.getLeft().getLValue()) {
            new ErrorType("Required lValue in left part of assignment statement", assignmentStatement.getLeft().getLine(), assignmentStatement.getLeft().getColumn());
        }

        assignmentStatement.getLeft().setType(
                assignmentStatement.getRight().getType().canPromote(
                        assignmentStatement.getLeft().getType()
                        , assignmentStatement
                ));

        return null;
    }

    @Override
    public Void visit(PrintStatement printStatement, Type parameter) {
        super.visit(printStatement, null);

        // Check if we cant only print BuiltIn types.

        printStatement.getPrintExpressions().forEach(expression -> {
            expression.setType(expression.getType().asBuiltIn(printStatement));
        });

        return null;
    }

    @Override
    public Void visit(ReadStatement readStatement, Type parameter) {
        super.visit(readStatement, null);

        readStatement.getReadExpressions().forEach(expression -> {
            if(!expression.getLValue())
                new ErrorType("Required lValue in expression of read statement", expression.getLine(), expression.getColumn());
        });

        readStatement.getReadExpressions().forEach(expression -> {
            expression.setType(expression.getType().asBuiltIn(readStatement));
        });

        return null;
    }

    /*
    * Como se infiere el tipo de la expresion logica dentro del if, si el tipo de la expresion es nulo.
    * */
    @Override
    public Void visit(IfElseStatement ifElseStatement, Type parameter) {
        super.visit(ifElseStatement, null);

        ifElseStatement.getCondition().getType().asLogical(ifElseStatement);

        return null;
    }

    @Override
    public Void visit(WhileStatement whileStatement, Type parameter) {
        super.visit(whileStatement, null);

        whileStatement.getCondition().getType().asLogical(whileStatement);

        return null;
    }

    // TODO Check if its ok.
    @Override
    public Void visit(FunctionDefinition functionDefinition, Type parameter) {
        super.visit(functionDefinition, ((FunctionType) functionDefinition.getType()).getReturnType());
        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement, Type parameter) {
        super.visit(returnStatement, parameter);

        returnStatement.getReturnExpression().getType().mustBeCompatible(parameter, returnStatement);

        return null;
    }
}
