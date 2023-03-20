package ast.type;

import semantic.Visitor;

import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> fields;

    public RecordType(List<RecordField> fields) {
        super(0, 0);

        this.fields = fields;
    }

    // TODO Implement accessor methods for the fields Attribute.

    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "RecordType{" +
                "fields=" + fields +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
