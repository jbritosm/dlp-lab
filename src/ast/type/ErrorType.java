package ast.type;

import errorhandler.ErrorHandler;

public class ErrorType extends AbstractType {

    private String msg;

    public ErrorType(String msg, int line, int column) {
        super(line, column);

        this.msg = msg;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return "ERROR: " + msg + " at Line: " + super.getLine() + " at Column: " + super.getColumn();
    }
}
