package ast.type;


import ast.definition.VariableDefinition;
import visitor.Visitor;

import java.util.ArrayList;
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
        return "FunctionType{" +
                "arguments=" + arguments +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
