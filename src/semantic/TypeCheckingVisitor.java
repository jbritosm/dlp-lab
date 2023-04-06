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

        arithmeticComparisonExpression.setType(
                arithmeticComparisonExpression.getLeft().getType().asComparison(
                        arithmeticComparisonExpression.getRight().getType()
                        , arithmeticComparisonExpression
                ));

        return null;
    }

    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Void parameter) {
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
    public Void visit(ArrayIndexExpression arrayIndexExpression, Void parameter) {
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
    public Void visit(CastExpression castExpression, Void parameter) {
        super.visit(castExpression, null);
        castExpression.setLValue(false);

        castExpression.setType(
                castExpression.getType().castTo(
                        castExpression.getTargetType()
                        , castExpression
                ));

        return null;
    }

    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Void parameter) {
        charLiteralExpression.setLValue(false);

        charLiteralExpression.setType(CharType.getInstance());

        return null;
    }

    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Void parameter) {
        super.visit(fieldAccessExpression, null);
        fieldAccessExpression.setLValue(false);

        fieldAccessExpression.setType(
                fieldAccessExpression.getAccessed().getType().dot(
                        fieldAccessExpression
                ));

        return null;
    }

    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Void parameter) {
        intLiteralExpression.setLValue(false);

        intLiteralExpression.setType(IntType.getInstance());

        return null;
    }

    @Override
    public Void visit(LogicComparisonExpression logicComparisonExpression, Void parameter) {
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
    public Void visit(NotExpression notExpression, Void parameter) {
        super.visit(notExpression, null);
        notExpression.setLValue(false);

        notExpression.setType(
                notExpression.getExpressionToNegate().getType().asNegation(
                        notExpression
                ));

        return null;
    }

    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Void parameter) {
        realLiteralExpression.setLValue(false);

        realLiteralExpression.setType(RealType.getInstance());

        return null;
    }

    @Override
    public Void visit(UnaryMinusExpression unaryMinusExpression, Void parameter) {
        super.visit(unaryMinusExpression, null);
        unaryMinusExpression.setLValue(false);

        unaryMinusExpression.setType(
                unaryMinusExpression.getExpression().getType().asUnaryMinus(
                        unaryMinusExpression
                ));

        return null;
    }

    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        variableExpression.setLValue(true);

        variableExpression.setType(variableExpression.getDefinition().getType());

        return null;
    }

    @Override
    public Void visit(FunctionInvocation functionInvocation, Void parameter) {
        super.visit(functionInvocation, null);
        functionInvocation.setLValue(false);

        /*
        * Posiblemente lo este liando y a la functionInvocation le tenga que meter function type como tipo
        * si el returntype es built in y sus argumentos tambien, en caso contrario le meto ErrorType.
        * */

        // Comprobamos que el return type de la funcion es built in
        Type type = functionInvocation.getVariableExpression().getType().asBuiltIn(functionInvocation);
        Type argType;

        // Si no es built in devuelve ErrorType y salta al return null;
        if(type instanceof ErrorType) {
            functionInvocation.setType(type);
        } else {
            // Si el return type es built in procesamos los argumentos
            for(Expression exp : functionInvocation.getArguments()) {
                argType = exp.getType().asBuiltIn(functionInvocation);
                // En caso de que haya un error type, se para de procesar.
                if(argType instanceof ErrorType) {
                    functionInvocation.setType(argType);
                    break;
                } else {
                    functionInvocation.setType(argType);
                }
            }
        }

        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Void parameter) {
        super.visit(assignmentStatement, null);

        if(assignmentStatement.getLeft().getLValue()) {
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
