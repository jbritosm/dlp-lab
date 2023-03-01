package ast.expression;

public class UnaryMinusExpression extends AbstractExpression {

    private Expression expression;

    public UnaryMinusExpression(Expression expression, int line, int column) {
        super(line, column);

        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "UnaryMinusExpression{" +
                "expression=" + expression +
                '}';
    }
}
