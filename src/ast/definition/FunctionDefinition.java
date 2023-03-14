package ast.definition;

import ast.statement.Statement;
import ast.type.Type;
import visitor.Visitor;

import java.util.List;

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
}
