package type;

import astnode.AbstractASTNode;

import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> fields;

    private RecordType() {
        super(0, 0);
    }

    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public Type createInstance() {
        return new RecordType();
    }
}
