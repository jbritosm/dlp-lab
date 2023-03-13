package ast.statement;

import ast.expression.Expression;
import visitor.Visitor;

public class AssignmentStatement extends AbstractStatement {

    private Expression left;
    private Expression right;

    public AssignmentStatement(Expression left, Expression right, int line, int column) {
        super(line, column);

        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "AssignmentStatement{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
