package ast.type;

import visitor.Visitor;

public class VoidType extends AbstractType {

    private static Type instance;

    private VoidType() {
        super(0, 0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new VoidType();
        return instance;
    }

    @Override
    public String toString() {
        return "VoidType{}";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
