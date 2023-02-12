package definition;

import astnode.AbstractASTNode;
import type.Type;

public class AbstractDefinition extends AbstractASTNode implements Definition {

    private Type type;
    private String name;

    public AbstractDefinition(Type type, String name, int line, int column) {
        super(line, column);

        this.type = type;
        this.name = name;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
