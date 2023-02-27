package ast.type;


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
}
