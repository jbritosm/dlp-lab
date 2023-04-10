package ast.type;

import ast.astnode.ASTNode;
import semantic.Visitor;

public class ArrayType extends AbstractType {

    private int size;
    private Type type;

    public ArrayType(Type type, int size) {
        super(0, 0);

        this.type = type;
        this.size = size;
    }

    // TODO Make accessor methods for the contents attribute.

    public int getSize() {
        return size;
    }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return "ArrayType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public Type squareBrackets(Type t, ASTNode node) {
        if(t instanceof IntType)
            return getType();
        if(t instanceof ErrorType)
            return t;
        return new ErrorType(String.format("The index of an array access must be integer, not %s", t), node.getLine(), node.getColumn());
    }

    @Override
    public int numberOfBytes() {
        return type.numberOfBytes() * size;
    }

    @Override
    public String getTypeExpression() {
        return "ArrayType";
    }


}
