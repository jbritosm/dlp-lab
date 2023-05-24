package ast.statement;

import ast.expression.Expression;
import semantic.Visitor;

import java.util.List;

public class WhileStatement extends AbstractStatement {

    private Expression condition;
    private List<Statement> body;

    public WhileStatement(Expression condition, List<Statement> body, int line, int column) {
        super(line, column);

        this.condition = condition;
        this.body = body;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "WhileStatement{" +
                "condition=" + condition +
                ", body=" + body +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
