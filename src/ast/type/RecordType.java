package ast.type;

import visitor.Visitor;

import java.util.ArrayList;
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
        return null;
    }
}
