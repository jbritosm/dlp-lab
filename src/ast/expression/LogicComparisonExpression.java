package ast.expression;

import semantic.Visitor;

public class LogicComparisonExpression extends AbstractExpression {

    private String operator;
    private Expression left;
    private Expression right;

    public LogicComparisonExpression(String operator, Expression left, Expression right, int line, int column) {
        super(line, column);

        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "LogicComparisonExpression{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
