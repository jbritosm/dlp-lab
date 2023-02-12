package statement;

import expression.Expression;

public class PrintStatement extends AbstractStatement {

    private Expression printExpression;

    public PrintStatement(Expression printExpression, int line, int column) {
        super(line, column);

        this.printExpression = printExpression;
    }

    public Expression getPrintExpression() {
        return printExpression;
    }
}
