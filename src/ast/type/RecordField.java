package ast.type;

import ast.astnode.AbstractASTNode;
import visitor.Visitor;

public class RecordField extends AbstractASTNode {

    private String name;
    private Type fieldType;

    private int line, column;

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

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
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
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
