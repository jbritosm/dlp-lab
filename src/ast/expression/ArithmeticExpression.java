package ast.expression;

import visitor.Visitor;

public class ArithmeticExpression extends AbstractExpression {

    private String operator;
    private Expression left;
    private Expression right;

    public ArithmeticExpression(String operator, Expression left, Expression right, int line, int column) {
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
        return "ArithmeticExpression{" +
                "operator='" + operator + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
