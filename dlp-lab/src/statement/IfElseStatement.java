package statement;

import expression.Expression;

import java.util.List;

public class IfElseStatement extends AbstractStatement {

    private Expression condition;
    private List<Statement> ifBody;
    private List<Statement> elseBody;

    public IfElseStatement(Expression condition, List<Statement> ifBody, List<Statement> elseBody, int line, int column) {
        super(line, column);

        this.condition = condition;
        this.ifBody = ifBody;
        this.elseBody = elseBody;
    }

    public Expression getCondition() {
        return condition;
    }

    public List<Statement> getIfBody() {
        return ifBody;
    }

    public List<Statement> getElseBody() {
        return elseBody;
    }
}
