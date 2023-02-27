package ast.type;

import java.util.ArrayList;
import java.util.List;

public class ArrayType extends AbstractType {

    private int size;

    public ArrayType(int size) {
        super(0, 0);

        this.size = size;
    }

    // TODO Make accessor methods for the contents attribute.

    public int getSize() {
        return size;
    }
}
