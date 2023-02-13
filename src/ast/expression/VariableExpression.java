package ast.expression;

public class VariableExpression extends AbstractExpression {

    private String name;

    public VariableExpression(String name, int line, int column) {
        super(line, column);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
