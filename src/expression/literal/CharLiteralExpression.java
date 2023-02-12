package expression.literal;

import astnode.AbstractASTNode;
import expression.AbstractExpression;
import expression.Expression;

public class CharLiteralExpression extends AbstractExpression {

    private char value;

    public CharLiteralExpression(char value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public char getValue() {
        return value;
    }

}
