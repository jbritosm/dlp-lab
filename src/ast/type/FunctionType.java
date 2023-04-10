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
        Type argumentInvocation;
        Type argumentDefinition;

        StringBuilder msg = new StringBuilder();

        if(types.size() != arguments.size()) {
            msg.append(String.format("Invalid number of parameters passed; Passed: %d, Requested: %d", types.size(), arguments.size()));
        } else {
            for(int i = 0; i < types.size(); i++) {
                argumentInvocation = types.get(i);
                argumentDefinition = arguments.get(i).getType();
                if(!(argumentInvocation.equals(argumentDefinition)))
                    msg.append(String.format("\nFunction invocation argument at index: %d has mismatched type %s, requested type %s.", i, argumentInvocation, argumentDefinition));
            }
        }
        if(msg.length() == 0) return this;
        return new ErrorType(msg.toString(), node.getLine(), node.getColumn());
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
