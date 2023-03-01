package ast.type;

import ast.astnode.AbstractASTNode;

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
    public String toString() {
        return "RecordField{" +
                "name='" + name + '\'' +
                ", fieldType=" + fieldType +
                ", line=" + line +
                ", column=" + column +
                '}';
    }
}
