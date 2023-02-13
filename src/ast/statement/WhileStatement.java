package ast.statement;

import ast.expression.Expression;

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
}
