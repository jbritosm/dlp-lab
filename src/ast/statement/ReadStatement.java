package ast.statement;

import ast.expression.Expression;

import java.util.List;

public class ReadStatement extends AbstractStatement {

    private List<Expression> readExpression;

    public ReadStatement(List<Expression> readExpression, int line, int column) {
        super(line, column);

        this.readExpression = readExpression;
    }

    public List<Expression> getReadExpressions() {
        return readExpression;
    }
}
