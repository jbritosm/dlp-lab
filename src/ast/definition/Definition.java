package ast.definition;

import ast.astnode.ASTNode;
import ast.type.Type;

public interface Definition extends ASTNode {
    Type getType();
    String getName();

    int getScope();
    void setScope(int scope);
}
