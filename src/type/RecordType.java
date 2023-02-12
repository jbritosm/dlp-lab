package type;

import java.util.ArrayList;
import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> fields;

    private RecordType() {
        super(0, 0);

        fields = new ArrayList<>();
    }

    // TODO Implement accessor methods for the fields Attribute.

    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public Type createInstance() {
        return new RecordType();
    }
}
