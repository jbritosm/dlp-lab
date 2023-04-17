package codegenerator;

import ast.expression.VariableExpression;
import semantic.AbstractVisitor;

/*
* Only defined for l-value expressions.
* */
public class AddressCGVisitor extends AbstractVisitor<Void, Void> {

    /**
     *  address[[Variable : expression -> ID]]() =
     *     if(expression.definition.scope == 0) {
     *         <pusha> expression.definition.offset
     *     } else {
     *         <push> bp
     *         <push> expression.definition.offset
     *         <addi>
     *      }
     */
    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        return null;
    }
}
