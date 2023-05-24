package ast.expression;

import ast.astnode.ASTNode;
import ast.type.Type;

public interface Expression extends ASTNode {
    boolean getLValue();
    void setLValue(boolean lValue);

    Type getType();
    void setType(Type type);
}
