package ast.expression;

import ast.expression.AbstractExpression;
import visitor.Visitor;

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
        return null;
    }
}
