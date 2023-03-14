package ast.type;


import visitor.Visitor;

public class IntType extends AbstractType {

    private static Type instance;

    private IntType() {
        super(0, 0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new IntType();
        return instance;
    }

    @Override
    public String toString() {
        return "IntType{}";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
