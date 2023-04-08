package semantic;

import ast.astnode.Program;
import ast.definition.FunctionDefinition;
import ast.expression.*;
import ast.functioninvocation.FunctionInvocation;
import ast.statement.*;
import ast.type.*;

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

        arithmeticComparisonExpression.getType().accept(this, null);

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

        arithmeticExpression.getType().accept(this, null);

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

        arrayIndexExpression.getType().accept(this, null);

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

        castExpression.getType().accept(this, null);

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
        // TODO Set to true because v[6] = 2;
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

        // Check number of parameters.
        // Check type of parameters.
        // Check return type, if void no return.

        /*
        * Posiblemente lo este liando y a la functionInvocation le tenga que meter function type como tipo
        * si el returntype es built in y sus argumentos tambien, en caso contrario le meto ErrorType.
        * */

        FunctionType returnType = (FunctionType) functionInvocation.getVariableExpression().getDefinition().getType();
        functionInvocation.setType(returnType.getReturnType());

        /*
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
        */

        return null;
    }

    @Override
    public Void visit(AssignmentStatement assignmentStatement, Type parameter) {
        super.visit(assignmentStatement, null);

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
        functionDefinition.getStatements().forEach(statement -> statement.accept(this, functionDefinition.getType()));
        functionDefinition.getType().accept(this, null);

        return null;
    }

    @Override
    public Void visit(ReturnStatement returnStatement, Type parameter) {
        super.visit(returnStatement, null);

        returnStatement.getReturnExpression().getType().mustBeCompatible(parameter, returnStatement);

        return null;
    }
}
