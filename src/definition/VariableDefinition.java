package definition;

import statement.Statement;
import type.Type;

public class VariableDefinition extends AbstractDefinition implements Statement {

    private int offset;

    public VariableDefinition(Type type, String name, int offset, int line, int column) {
        super(type, name, line, column);

        this.offset = offset;
    }

    public int getOffset() {
        return offset;
    }
}
