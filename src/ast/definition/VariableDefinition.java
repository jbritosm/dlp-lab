package ast.definition;

import ast.statement.Statement;
import ast.type.Type;

public class VariableDefinition extends AbstractDefinition implements Statement {

    public VariableDefinition(Type type, String name, int line, int column) {
        super(type, name, line, column);
    }


}
