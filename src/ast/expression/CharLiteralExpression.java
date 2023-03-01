package ast.expression;

import ast.expression.AbstractExpression;

public class CharLiteralExpression extends AbstractExpression {

    private char value;

    public CharLiteralExpression(char value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CharLiteralExpression{" +
                "value=" + value +
                '}';
    }
}
