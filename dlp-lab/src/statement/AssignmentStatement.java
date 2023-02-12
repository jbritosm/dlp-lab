package statement;

import expression.Expression;

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
}
