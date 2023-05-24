package ast.type;


import ast.astnode.ASTNode;
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
    public Type checkArgumentTypes(List<Type> types, ASTNode node) {

        // Check the number of the parameters
        if(types.size() != arguments.size())
            return new ErrorType(String.format("Invalid number of parameters passed; Passed: %d, Requested: %d", types.size(), arguments.size()), node.getLine(), node.getColumn());
        // Check the type of the parameters
        for(int i = 0; i < types.size(); i++) {
            if(!(types.get(i).equals(arguments.get(i).getType())))
                return new ErrorType(String.format("\nFunction invocation argument at index: %d has mismatched type %s, requested type %s.", i, types.get(i), arguments.get(i).getType()), node.getLine(), node.getColumn());
        }

        return returnType;
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }
}
