package ast.type;

public class RecordField {

    private String name;
    private Type fieldType;

    private int line, column;

    public RecordField(String name, Type fieldType, int line, int column) {
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
}
