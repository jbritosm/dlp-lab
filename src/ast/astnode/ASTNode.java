package ast.astnode;

import semantic.Visitor;

public interface ASTNode {
    int getLine();
    int getColumn();

    <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter);
}
