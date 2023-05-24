package semantic;

import ast.definition.Definition;
import ast.definition.FunctionDefinition;
import ast.definition.VariableDefinition;
import ast.expression.VariableExpression;

import ast.type.ErrorType;
import symboltable.SymbolTable;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {
    private SymbolTable st = new SymbolTable();

    @Override
    public Void visit(FunctionDefinition functionDefinition, Void parameter) {
        st.insert(functionDefinition);
        st.set();
        super.visit(functionDefinition, parameter);
        st.reset();

        return null;
    }
    @Override
    public Void visit(VariableDefinition variableDefinition, Void parameter) {
        if(!st.insert(variableDefinition)) {
            new ErrorType("Variable definition: " + variableDefinition.getName() + ", already defined in scope.", variableDefinition.getLine(), variableDefinition.getColumn());
        }
        return null;
    }

    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        Definition varDef = st.findInCurrentScope(variableExpression.getName());
        if(varDef == null) varDef = st.find(variableExpression.getName());

        if(varDef == null) {
            varDef = new VariableDefinition(new ErrorType("Definition: " + variableExpression.getName() + ", not defined"
                                                                    , variableExpression.getLine()
                                                                    , variableExpression.getColumn())
                                                                    , variableExpression.getName()
                                                                    , variableExpression.getLine()
                                                                    , variableExpression.getColumn());
        }

        variableExpression.setDefinition(varDef);

        return null;
    }

}
