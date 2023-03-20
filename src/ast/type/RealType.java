package ast.type;

import semantic.Visitor;

public class RealType extends AbstractType {

    private static Type instance;

    private RealType() {
        super(0, 0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new RealType();
        return instance;
    }

    @Override
    public String toString() {
        return "RealType{}";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
