package ast.statement;

import ast.expression.Expression;
import semantic.Visitor;

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

    @Override
    public String toString() {
        return "IfElseStatement{" +
                "condition=" + condition +
                ", ifBody=" + ifBody +
                ", elseBody=" + elseBody +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
