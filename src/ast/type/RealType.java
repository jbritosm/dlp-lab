package ast.type;

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
}
