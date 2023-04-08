package ast.type;

import ast.astnode.ASTNode;
import semantic.Visitor;

import java.util.List;

public class RecordType extends AbstractType {

    private List<RecordField> fields;

    public RecordType(List<RecordField> fields) {
        super(0, 0);

        this.fields = fields;
    }


    public List<RecordField> getFields() {
        return fields;
    }

    @Override
    public String toString() {
        return "RecordType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public Type dot(String id, ASTNode node) {
        for(RecordField field : getFields()) {
            if(field.getName().equals(id))
                return field.getFieldType();
        }
        return new ErrorType(String.format("No field found with id: %s.", id), node.getLine(), node.getColumn());
    }

    @Override
    public String getTypeExpression() {
        return "RecordType";
    }
}
