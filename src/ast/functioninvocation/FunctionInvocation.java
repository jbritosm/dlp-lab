package ast.functioninvocation;

import ast.expression.AbstractExpression;
import ast.expression.Expression;
import ast.expression.VariableExpression;
import ast.statement.Statement;
import semantic.Visitor;

import java.util.List;

public class FunctionInvocation extends AbstractExpression implements Statement {

    // We use a variable to store the name of the function.
    private VariableExpression variableExpression;
    private List<Expression> arguments;

    public FunctionInvocation(VariableExpression variableExpression, List<Expression> arguments, int line, int column) {
        super(line, column);

        this.variableExpression = variableExpression;
        this.arguments = arguments;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    public VariableExpression getVariableExpression() {
        return variableExpression;
    }

    @Override
    public String toString() {
        return "FunctionInvocation{" +
                "variableExpression=" + variableExpression +
                ", arguments=" + arguments +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
