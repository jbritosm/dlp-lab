package codegenerator;

import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.type.FunctionType;
import ast.type.RecordField;
import ast.type.RecordType;
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
        // Each time we enter a new function we reset the bytes of
        // the local variables
        localVarBytes = 0;

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
    public Void visit(RecordType recordType, Void parameter) {
        super.visit(recordType, parameter);

        int recordFieldBytes = 0;

        for(RecordField field : recordType.getFields()) {
            field.setOffset(recordFieldBytes);
            recordFieldBytes += field.getFieldType().numberOfBytes();
        }

        return null;
    }
}
