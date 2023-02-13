package ast.expression;

import java.util.List;

public class FunctionInvocationExpression extends AbstractExpression {

    // We use a variable to store the name of the function.
    private VariableExpression variableExpression;
    private List<Expression> arguments;

    public FunctionInvocationExpression(VariableExpression variableExpression, List<Expression> arguments, int line, int column) {
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
}
