package type;

import astnode.AbstractASTNode;

public class VoidType extends AbstractType {

    private VoidType() {
        super(0, 0);
    }

    @Override
    public Type createInstance() {
        return new VoidType();
    }
}
