package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {

    public VariableDefinition(Type type, String name, int line, int column) {
        super(type, name, line, column);
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
