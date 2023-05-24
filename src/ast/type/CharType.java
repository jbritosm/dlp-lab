package ast.type;

import ast.astnode.ASTNode;
import semantic.Visitor;

public class CharType extends AbstractType {

    private static Type instance;

    private CharType() {
        super(0,0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new CharType();
        return instance;
    }

    @Override
    public String toString() {
        return "CharType";
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
        if(t instanceof CharType)
            return IntType.getInstance();
        return new ErrorType(String.format("An integer cannot operate with a %s", t), node.getLine(), node.getColumn());
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
        if(t instanceof CharType)
            return t;
        if(t instanceof IntType)
            return t;
        if(t instanceof RealType)
            return t;
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("Char type cannot be casted to %s type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type mustBeCompatible(Type t, ASTNode node) {
        if(t instanceof CharType) return t;
        return new ErrorType(String.format("%s is not compatible with CharType for return type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type canPromote(Type t, ASTNode node) {
        if(t instanceof CharType)
            return t;
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("CharType cannot be promoted to %s.", t), node.getLine(), node.getColumn());
    }

    @Override
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public Type asComparison(Type type, ASTNode node) {
        if(type instanceof CharType)
            return IntType.getInstance();
        return new ErrorType(String.format("Comparison operation not allowed between CharType and %s", type), node.getLine(), node.getColumn());
    }

    @Override
    public String getTypeExpression() {
        return "CharType";
    }

    @Override
    public String getSuffix() {
        return "b";
    }
}
