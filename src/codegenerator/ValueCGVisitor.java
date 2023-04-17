package codegenerator;

import ast.expression.ArithmeticComparisonExpression;
import ast.expression.ArithmeticExpression;
import ast.expression.VariableExpression;
import semantic.AbstractVisitor;

public class ValueCGVisitor extends AbstractVisitor<Void, Void> {

    /**
     * value[[VariableExpression : expression -> ID]]() =
     *     address[[expression]]()
     *     <load> expression.type.suffix()
     */
    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        return null;
    }

    /**
     * value[[ArithmeticComparisonExpression : expression -> expression1 ('>'|'>='|'<'|'=<'|'!='|'==') expression2]]() =
     *  value[[expression1]]
     *  value[[expression2]]
     *  (gt, lt, ge, le, eq, ne) expression.type.suffix()
     *
     */
    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Void parameter) {
        return null;
    }

}
