package ast.expression;

import ast.type.Type;

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
}
