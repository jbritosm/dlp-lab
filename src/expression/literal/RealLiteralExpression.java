package expression.literal;

import astnode.AbstractASTNode;
import expression.AbstractExpression;
import expression.Expression;

public class RealLiteralExpression extends AbstractExpression {

    private double value;

    public RealLiteralExpression(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
