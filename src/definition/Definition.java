package definition;

import astnode.ASTNode;
import type.Type;

public interface Definition extends ASTNode {
    Type getType();
    String getName();
}
