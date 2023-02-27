package ast.functioninvocation;

import ast.expression.Expression;
import ast.expression.VariableExpression;
import ast.statement.AbstractStatement;

import java.util.List;

public class FunctionInvocation extends AbstractStatement implements Expression {

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
}
