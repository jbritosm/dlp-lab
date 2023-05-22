package ast.definition;

import ast.statement.Statement;
import ast.type.FunctionType;
import ast.type.Type;
import semantic.Visitor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FunctionDefinition extends AbstractDefinition {

    private List<Statement> statements;

    public FunctionDefinition(Type type, String name, List<Statement> statements, int line, int column) {
        super(type, name, line, column);

        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public String toString() {
        return "FunctionDefinition{" +
                "statements=" + statements +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    public int localsNumberOfBytes() {
        int numberOfBytes = 0;

        for(Statement stm : statements) {
            if(stm instanceof VariableDefinition)
                numberOfBytes += ((VariableDefinition) stm).getType().numberOfBytes();
        }

        return numberOfBytes;
    }

    public int argumentsNumberOfBytes() {
        int numberOfBytes = 0;

        FunctionType functionType = (FunctionType) this.getType();

        for(VariableDefinition varDef : functionType.getArguments()) {
            numberOfBytes += varDef.getType().numberOfBytes();
        }

        return numberOfBytes;
    }
}
