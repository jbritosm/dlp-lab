package ast.type;

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
}
