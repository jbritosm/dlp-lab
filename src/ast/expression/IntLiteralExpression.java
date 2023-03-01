package ast.expression;

import ast.expression.AbstractExpression;

public class IntLiteralExpression extends AbstractExpression {

    private int value;

    public IntLiteralExpression(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IntLiteralExpression{" +
                "value=" + value +
                '}';
    }
}
