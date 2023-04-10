package codegenerator;

import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.type.FunctionType;
import ast.type.RecordField;
import examples.ast.Variable;
import semantic.AbstractVisitor;

import java.util.List;
import java.util.function.Function;

public class OffSetVisitor extends AbstractVisitor<Void, Void> {

    private int globalVarBytes = 0;
    private int localVarBytes = 0;

    @Override
    public Void visit(VariableDefinition variableDefinition, Void parameter) {
        super.visit(variableDefinition, parameter);

        if(variableDefinition.getScope() == 0) {
            variableDefinition.setOffset(globalVarBytes);
            globalVarBytes += variableDefinition.getType().numberOfBytes();
        } else {
            localVarBytes += variableDefinition.getType().numberOfBytes();
            variableDefinition.setOffset(-1 * localVarBytes);
        }

        return null;
    }

    @Override
    public Void visit(FunctionType functionType, Void parameter) {
        List<VariableDefinition> arguments = functionType.getArguments();
        VariableDefinition varDef;

        int accumulatedOffset = 4;

        for(int i = arguments.size() - 1; i >= 0; i--) {
            varDef = arguments.get(i);
            varDef.setOffset(accumulatedOffset);
            accumulatedOffset += varDef.getType().numberOfBytes();
        }

        return null;
    }

    @Override
    public Void visit(RecordField recordField, Void parameter) {
        recordField.setOffset(globalVarBytes);
        globalVarBytes += recordField.getFieldType().numberOfBytes();
        return null;
    }
}
