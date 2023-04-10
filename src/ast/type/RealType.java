package ast.type;

import ast.astnode.ASTNode;
import com.sun.jdi.DoubleType;
import semantic.Visitor;

public class RealType extends AbstractType {

    private static Type instance;

    private RealType() {
        super(0, 0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new RealType();
        return instance;
    }

    @Override
    public String toString() {
        return "RealType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public Type asArithmetic(Type t, ASTNode node) {
        if(t instanceof RealType)
            return t;
        return new ErrorType(String.format("A double cannot operate with a %s", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type asComparison(Type type, ASTNode node) {
        if(type instanceof RealType)
            return IntType.getInstance();
        return new ErrorType(String.format("Comparison operation not allowed between IntType and %s", type), node.getLine(), node.getColumn());
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return RealType.getInstance();
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return RealType.getInstance();
    }

    @Override
    public Type castTo(Type t, ASTNode node) {
        if(t instanceof RealType)
            return t;
        if(t instanceof IntType)
            return t;
        return new ErrorType(String.format("Real type cannot be casted to %s type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type mustBeCompatible(Type t, ASTNode node) {
        if(t instanceof RealType) return t;
        return new ErrorType(String.format("%s is not compatible with RealType for return type.", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type canPromote(Type t, ASTNode node) {
        if(t instanceof RealType)
            return t;
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("RealType cannot be promoted to %s.", t), node.getLine(), node.getColumn());
    }

    @Override
    public String getTypeExpression() {
        return "RealType";
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }
}
