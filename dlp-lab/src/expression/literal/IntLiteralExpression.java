package expression.literal;

import astnode.AbstractASTNode;
import expression.Expression;

public class IntLiteralExpression extends AbstractASTNode implements Expression {

    private int value;

    public IntLiteralExpression(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
