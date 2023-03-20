package ast.type;

import semantic.Visitor;

public class CharType extends AbstractType {

    private static Type instance;

    private CharType() {
        super(0,0);
    }

    public static Type getInstance() {
        if(instance == null)
            instance = new CharType();
        return instance;
    }

    @Override
    public String toString() {
        return "CharType{}";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
