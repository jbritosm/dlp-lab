package statement;

import expression.Expression;

public class ReadStatement extends AbstractStatement {

    private Expression readExpression;

    public ReadStatement(Expression readExpression, int line, int column) {
        super(line, column);

        this.readExpression = readExpression;
    }

    public Expression getReadExpression() {
        return readExpression;
    }
}
