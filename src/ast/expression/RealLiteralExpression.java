package ast.expression;

import semantic.Visitor;

public class RealLiteralExpression extends AbstractExpression {

    private double value;

    public RealLiteralExpression(Double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RealLiteralExpression{" +
                "value=" + value +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
