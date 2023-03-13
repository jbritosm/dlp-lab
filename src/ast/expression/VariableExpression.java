package ast.expression;

import visitor.Visitor;

public class VariableExpression extends AbstractExpression {

    private String name;

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
        return null;
    }
}
