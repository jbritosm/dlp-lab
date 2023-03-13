package ast.statement;

import ast.astnode.AbstractASTNode;
import visitor.Visitor;


public abstract class AbstractStatement extends AbstractASTNode implements Statement {
    public AbstractStatement(int line, int column) {
        super(line, column);
    }
}
