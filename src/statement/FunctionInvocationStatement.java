package statement;

import expression.Expression;

import java.util.List;

public class FunctionInvocationStatement extends AbstractStatement implements Expression {

    private List<Expression> arguments;

    public FunctionInvocationStatement(List<Expression> arguments, int line, int column) {
        super(line, column);

        this.arguments = arguments;
    }

    public List<Expression> getArguments() {
        return arguments;
    }
}
