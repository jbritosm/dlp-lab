package type;

public class RecordField {

    private String name;
    private Type fieldType;

    public RecordField(String name, Type fieldType) {
        this.name = name;
        this.fieldType = fieldType;
    }

    public String getName() {
        return name;
    }

    public Type getFieldType() {
        return fieldType;
    }
}
