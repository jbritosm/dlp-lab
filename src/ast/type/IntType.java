package ast.type;


import ast.astnode.ASTNode;
import semantic.Visitor;

public class IntType extends AbstractType {

    private static Type instance;

    private IntType() {
        super(0, 0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new IntType();
        return instance;
    }

    @Override
    public String toString() {
        return "IntType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public Type asArithmetic(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        return new ErrorType(String.format("An integer cannot operate with a %s", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type asLogical(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        return new ErrorType(String.format("Integer type cannot be compared with %s type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type asLogical(ASTNode node) {
        return this;
    }

    @Override
    public Type asNegation(ASTNode node) {
        return this;
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return this;
    }

    @Override
    public Type castTo(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        if(t instanceof RealType)
            return t;
        if(t instanceof CharType)
            return t;
        return new ErrorType(String.format("Integer cannot be casted to %s type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type mustBeCompatible(Type t, ASTNode node) {
        Type returnType;
        if(t instanceof FunctionType) {
            returnType = ((FunctionType) t).getReturnType();
            if (returnType instanceof IntType)
                return returnType;
            return new ErrorType(String.format("Return type: %s of the function not compatible with IntegerType", returnType.getTypeExpression()), node.getLine(), node.getColumn());
        }
        return new ErrorType(String.format("Return type: %s of the function not compatible with IntegerType", t.getTypeExpression()), node.getLine(), node.getColumn());
    }

    @Override
    public Type canPromote(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        return new ErrorType(String.format("%s type cannot be promoted to IntegerType.", t), node.getLine(), node.getColumn());
    }

    @Override
    public String getTypeExpression() {
        return "IntType";
    }
}
