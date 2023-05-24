package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import semantic.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {

    private int offset;
    public VariableDefinition(Type type, String name, int line, int column) {
        super(type, name, line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
