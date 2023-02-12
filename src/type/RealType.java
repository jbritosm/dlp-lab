package type;

public class RealType extends AbstractType {

    private RealType() {
        super(0, 0);
    }

    @Override
    public Type createInstance() {
        return new RealType();
    }
}
