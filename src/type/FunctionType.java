package type;


import definition.VariableDefinition;

import java.util.ArrayList;
import java.util.List;

public class FunctionType extends AbstractType {

    private List<VariableDefinition> variableDefinition;
    private Type returnType;

    private FunctionType() {
        super(0, 0);

        this.variableDefinition = new ArrayList<>();
        // How do we get the return type?
    }

    public List<VariableDefinition> getVariableDefinition() {
        return variableDefinition;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public Type createInstance() {
        return new FunctionType();
    }
}
