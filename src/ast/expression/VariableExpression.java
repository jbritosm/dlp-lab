package ast.expression;

import ast.definition.Definition;
import semantic.Visitor;

public class VariableExpression extends AbstractExpression {

    private String name;
    private Definition definition;

    public VariableExpression(String name, int line, int column) {
        super(line, column);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VariableExpression{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    public void setDefinition(Definition definition) {
        this.definition = definition;
    }

    public Definition getDefinition() {
        return definition;
    }
}
