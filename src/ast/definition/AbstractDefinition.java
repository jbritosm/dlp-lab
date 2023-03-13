package ast.definition;

import ast.astnode.AbstractASTNode;
import ast.type.Type;
import visitor.Visitor;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

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

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbstractDefinition{" +
                "type=" + type +
                ", name='" + name + '\'' +
                '}';
    }
}
