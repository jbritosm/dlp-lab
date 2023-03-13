package ast.expression;

import ast.expression.AbstractExpression;
import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
