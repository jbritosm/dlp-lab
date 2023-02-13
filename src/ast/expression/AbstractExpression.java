package ast.expression;

import ast.astnode.AbstractASTNode;

public class AbstractExpression extends AbstractASTNode implements Expression {
    public AbstractExpression(int line, int column) {
        super(line, column);
    }
}
