package ast.type;

import java.util.ArrayList;
import java.util.List;

public class ArrayType extends AbstractType {

    private List<Type> contents;
    private int size;

    private ArrayType() {
        super(0, 0);

        this.contents = new ArrayList<>();
        this.size = contents.size();
    }

    // TODO Make accessor methods for the contents attribute.

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
