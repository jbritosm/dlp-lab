package ast.type;

import ast.astnode.AbstractASTNode;

public abstract class AbstractType extends AbstractASTNode implements Type {

    protected Type instance;

    public AbstractType(int line, int column) {
        super(line, column);
    }

    public abstract Type createInstance();

    public Type getInstance() {
        if(instance == null)
            instance = createInstance();
        return instance;
    }

}
