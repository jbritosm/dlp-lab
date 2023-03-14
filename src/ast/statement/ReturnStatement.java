package ast.statement;

import ast.expression.Expression;
import visitor.Visitor;

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

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
