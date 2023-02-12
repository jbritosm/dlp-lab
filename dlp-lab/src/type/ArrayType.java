package type;

import astnode.AbstractASTNode;

import java.util.List;

public class ArrayType extends AbstractType {

    private List<Type> contents;
    private int size;

    private ArrayType() {
        super(0, 0);
    }

    public List<Type> getContents() {
        return contents;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Type createInstance() {
        return new ArrayType();
    }
}
