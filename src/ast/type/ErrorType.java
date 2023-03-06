package ast.type;

public class ErrorType extends AbstractType {

    private String msg;

    public ErrorType(String msg, int line, int column) {
        super(line, column);

        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ERROR: " + msg + " at Line: " + super.getLine() + " at Column: " + super.getColumn();
    }
}
