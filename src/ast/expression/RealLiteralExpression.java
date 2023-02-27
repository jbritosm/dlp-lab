package ast.expression;

import ast.expression.AbstractExpression;

public class RealLiteralExpression extends AbstractExpression {

    private double value;

    public RealLiteralExpression(Double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
