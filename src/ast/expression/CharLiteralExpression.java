package ast.expression;

import semantic.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
