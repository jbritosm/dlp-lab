package errorhandler;

import ast.type.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private List<ErrorType> errors;
    private static ErrorHandler instance;

    private ErrorHandler() {
        errors = new ArrayList<>();
    }

    /**
     * In case there are any errors (the errors list is not empty)
     * this function will return TRUE, it will return FALSE otherwise.
     * @return
     */
    public boolean anyError() {
        return !errors.isEmpty();
    }

    public void showErrors(PrintStream ps) {
        for (ErrorType error: errors)
            ps.print(error.toString());
    }

    public void addError(ErrorType et) {
        errors.add(et);
    }

    public static ErrorHandler getInstance() {
        if(instance == null)
            instance = new ErrorHandler();
        return instance;
    }

}
