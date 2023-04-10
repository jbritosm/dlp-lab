package ast.type;

import ast.astnode.AbstractASTNode;
import semantic.Visitor;

public class RecordField extends AbstractASTNode {

    private String name;
    private Type fieldType;
    private int offset;

    public RecordField(String name, Type fieldType, int line, int column) {
        super(line, column);
        this.name = name;
        this.fieldType = fieldType;
    }

    public String getName() {
        return name;
    }

    public Type getFieldType() {
        return fieldType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public String toString() {
        return "RecordField{" +
                "name='" + name + '\'' +
                ", fieldType=" + fieldType +
                '}';
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
