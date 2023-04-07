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
        return "CharType{}";
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
    public Type asComparison(Type t, ASTNode node) {
        if(t instanceof IntType)
            return t;
        return new ErrorType(String.format("An integer cannot be compared with a %s", t), node.getLine(), node.getColumn());
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return this;
    }
}
