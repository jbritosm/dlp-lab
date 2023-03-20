package ast.expression;

import ast.astnode.ASTNode;

public interface Expression extends ASTNode {
    boolean getLValue();
    void setLValue(boolean lValue);
}
