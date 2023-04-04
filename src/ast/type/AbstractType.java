package ast.type;

import ast.astnode.ASTNode;
import ast.astnode.AbstractASTNode;
import semantic.Visitor;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public Type asArithmetic(Type type, ASTNode node) {
        return new ErrorType(String.format("Arithmetic operation not supported for %s and %s types.", this, type), node.getLine(), node.getColumn());
    }

    @Override
    public Type asComparison(Type type, ASTNode node) {
        return new ErrorType(String.format("Comparison not supported for %s and %s types.", this, type), node.getLine(), node.getColumn());
    }

    @Override
    public Type squareBrackets(Type type, ASTNode node) {
        return new ErrorType(String.format("Index operation not supported for %s and %s types.", this, type), node.getLine(), node.getColumn());
    }

    @Override
    public Type castTo(Type type, ASTNode node) {
        return new ErrorType(String.format("Cast operation not supported for %s and %s types.", this, type), node.getLine(), node.getColumn());
    }

    @Override
    public Type dot(ASTNode node) {
        return new ErrorType(String.format("Access operation not supported for %s type.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type asLogical(Type type, ASTNode node) {
        return new ErrorType(String.format("Logical operation not supported for %s and %s types.", this, type.toString()), node.getLine(), node.getColumn());
    }

    @Override
    public Type asNegation(ASTNode node) {
        return new ErrorType(String.format("Negation operation not supported for %s type.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type asUnaryMinus(ASTNode node) {
        return new ErrorType(String.format("UnaryMinus operation not supported for %s type.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type asBuiltIn(Type type, ASTNode node) {
        return new ErrorType(String.format("%s type is not a Built-in type.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type canPromote(Type type, ASTNode node) {
        return new ErrorType(String.format("Type %s can not be promoted to %s type.", type.toString(), this), node.getLine(), node.getColumn());
    }

    @Override // Check int type
    public Type asLogical(ASTNode node) {
        return new ErrorType(String.format("Type %s not supported for logical expression.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type asBuiltIn(ASTNode node) {
        return new ErrorType(String.format("%s type is not a Built-in type.", this), node.getLine(), node.getColumn());
    }

    @Override
    public Type mustBeCompatible(Type type, ASTNode node) {
        return new ErrorType(String.format("Type %s is not compatible with %s type.", this, type.toString()), node.getLine(), node.getColumn());
    }

    @Override
    public abstract <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter);
}
