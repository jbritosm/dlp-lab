package ast.expression;

import semantic.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
