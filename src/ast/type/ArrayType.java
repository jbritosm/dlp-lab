package ast.type;

import java.util.ArrayList;
import java.util.List;

public class ArrayType extends AbstractType {

    private int size;
    private Type type;

    public ArrayType(Type type, int size) {
        super(0, 0);

        this.type = type;
        this.size = size;
    }

    // TODO Make accessor methods for the contents attribute.

    public int getSize() {
        return size;
    }
    public Type getType() { return type; }

    @Override
    public String toString() {
        return "ArrayType{" +
                "size=" + size +
                ", type=" + type +
                '}';
    }
}
