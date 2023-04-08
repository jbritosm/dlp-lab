package ast.type;


import ast.definition.VariableDefinition;
import semantic.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {

    private List<VariableDefinition> arguments;
    private Type returnType;

    public FunctionType(List<VariableDefinition> arguments, Type returnType) {
        super(0, 0);

        this.arguments = arguments;
        this.returnType = returnType;
    }

    public List<VariableDefinition> getArguments() {
        return arguments;
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        return "FunctionType";
    }

    @Override
    public String getTypeExpression() {
        return "FunctionType";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }
}
