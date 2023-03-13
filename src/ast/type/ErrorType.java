package ast.type;

import errorhandler.ErrorHandler;
import visitor.Visitor;

public class ErrorType extends AbstractType {

    private String msg;

    public ErrorType(String msg, int line, int column) {
        super(line, column);

        this.msg = msg;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return "ERROR at Line: " + super.getLine() + ", Column: " + super.getColumn() + ", Cause: " + msg + "\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
