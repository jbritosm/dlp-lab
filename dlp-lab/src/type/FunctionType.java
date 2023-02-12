package type;


import java.util.List;

public class FunctionType extends AbstractType {

    private List<VariableDefinition> variableDefinition;
    private Type returnType;

    private FunctionType() {
        super(0, 0);
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
