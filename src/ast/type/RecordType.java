package ast.type;

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
}
