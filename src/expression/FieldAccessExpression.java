package expression;

public class FieldAccessExpression extends AbstractExpression {

    // Expression being accessed.
    private Expression accessed;
    private String name;

    public FieldAccessExpression(Expression accessed, String name, int line, int column) {
        super(line, column);

        this.accessed = accessed;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Expression getAccessed() {
        return accessed;
    }
}
