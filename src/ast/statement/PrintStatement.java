package ast.statement;

import ast.expression.Expression;
import semantic.Visitor;

import java.util.List;

public class PrintStatement extends AbstractStatement {

    private List<Expression> printExpressions;

    public PrintStatement(List<Expression> printExpressions, int line, int column) {
        super(line, column);

        this.printExpressions = printExpressions;
    }

    public List<Expression> getPrintExpressions() {
        return printExpressions;
    }

    @Override
    public String toString() {
        return "PrintStatement{" +
                "printExpressions=" + printExpressions +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
