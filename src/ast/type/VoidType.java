package ast.type;

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
}
