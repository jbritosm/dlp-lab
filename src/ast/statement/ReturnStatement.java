package ast.statement;

import ast.expression.Expression;

public class ReturnStatement extends AbstractStatement {

    private Expression returnExpression;

    public ReturnStatement(Expression returnExpression, int line, int column) {
        super(line, column);

        this.returnExpression = returnExpression;
    }

    public Expression getReturnExpression() {
        return returnExpression;
    }

    @Override
    public String toString() {
        return "ReturnStatement{" +
                "returnExpression=" + returnExpression +
                '}';
    }
}
