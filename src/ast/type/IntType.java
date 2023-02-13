package ast.type;


public class IntType extends AbstractType {

    private IntType() {
        super(0, 0);
    }

    @Override
    public Type createInstance() {
        return new IntType();
    }
}
