package expression.literal;

import astnode.AbstractASTNode;
import expression.Expression;

public class RealLiteralExpression extends AbstractASTNode implements Expression {

    private double value;

    public RealLiteralExpression(int value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
