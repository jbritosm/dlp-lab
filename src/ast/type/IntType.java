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
        if(t instanceof CharType) // TODO Are we allowed to do 'a' + 1?
            return IntType.getInstance();
        if(t instanceof RealType)
            return RealType.getInstance();
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("An integer cannot operate with a %s", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type asComparison(Type type, ASTNode node) {
        if(type instanceof IntType)
            return IntType.getInstance();
        return new ErrorType(String.format("Comparison operation not allowed between IntType and %s", type), node.getLine(), node.getColumn());
    }

    @Override
    public Type asLogical(Type type, ASTNode node) {
        if(type instanceof IntType)
            return IntType.getInstance();
        return new ErrorType(String.format("Logical operation not allowed between IntType and %s.", type), node.getLine(), node.getColumn());
    }
    @Override
    public Type asLogical(ASTNode node) {
        return IntType.getInstance();
    }

    @Override
    public Type asNegation(ASTNode node) {
        return IntType.getInstance();
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return IntType.getInstance();
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return IntType.getInstance();
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
        if(t instanceof IntType) return t;
        return new ErrorType(String.format("%s is not compatible with IntType for return type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type canPromote(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("IntType cannot be promoted to %s.", t), node.getLine(), node.getColumn());
    }

    @Override
    public String getTypeExpression() {
        return "IntType";
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String getSuffix() {
        return "i";
    }

    @Override
    public String convertTo(Type type) {
        if(type instanceof IntType)
            return "";
        else if(type instanceof RealType)
            return "\ti2f";
        else if(type instanceof CharType)
            return "\ti2b";
        else throw new IllegalStateException(String.format("Cannot perform conversion from %s to %s"
                                                            , this.getTypeExpression(), type.getTypeExpression()));

    }
}
