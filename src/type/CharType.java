package type;

public class CharType extends AbstractType {
    private CharType() {
        super(0,0);
    }

    @Override
    public Type createInstance() {
        return new CharType();
    }
}
