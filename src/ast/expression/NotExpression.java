package ast.expression;

public class NotExpression extends AbstractExpression {

    private Expression expressionToNegate;

    public NotExpression(Expression expressionToNegate, int line, int column) {
        super(line, column);

        this.expressionToNegate = expressionToNegate;
    }

    public Expression getExpressionToNegate() {
        return expressionToNegate;
    }

    @Override
    public String toString() {
        return "NotExpression{" +
                "expressionToNegate=" + expressionToNegate +
                '}';
    }
}
