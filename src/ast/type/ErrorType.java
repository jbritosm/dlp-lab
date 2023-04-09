package ast.type;

import ast.astnode.ASTNode;
import errorhandler.ErrorHandler;
import semantic.Visitor;

public class ErrorType extends AbstractType {

    private String msg;

    public ErrorType(String msg, int line, int column) {
        super(line, column);

        this.msg = msg;

        ErrorHandler.getInstance().addError(this);
    }

    @Override
    public String toString() {
        return "ERROR at Line: " + super.getLine() + ", Column: " + super.getColumn() + ", Cause: " + msg + "\n";
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        v.visit(this, parameter);

        return null;
    }

    @Override
    public Type asArithmetic(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type castTo(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type dot(String id, ASTNode node) {
        return this;
    }

    @Override
    public Type asLogical(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type asNegation(ASTNode node) {
        return this;
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return this;
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return this;
    }

    @Override
    public Type mustBeCompatible(Type type, ASTNode node) {
        return this;
    }

    @Override
    public Type canPromote(Type type, ASTNode node) { return this; }

    @Override
    public String getTypeExpression() {
        return "ErrorType";
    }
}
