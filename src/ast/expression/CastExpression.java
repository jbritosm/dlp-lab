package ast.expression;

import ast.type.Type;
import semantic.Visitor;

public class CastExpression extends AbstractExpression {


    private Type targetType;
    private Expression expressionToCast;

    public CastExpression(Type targetType, Expression expressionToCast, int line, int column) {
        super(line, column);

        this.targetType = targetType;
        this.expressionToCast = expressionToCast;
    }

    public Type getTargetType() {
        return targetType;
    }

    public Expression getExpressionToCast() {
        return expressionToCast;
    }

    @Override
    public String toString() {
        return "CastExpression{" +
                "targetType=" + targetType +
                ", expressionToCast=" + expressionToCast +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
