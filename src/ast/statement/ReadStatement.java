package ast.statement;

import ast.expression.Expression;
import visitor.Visitor;

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

    @Override
    public String toString() {
        return "ReadStatement{" +
                "readExpression=" + readExpression +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
