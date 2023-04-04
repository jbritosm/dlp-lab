package ast.type;

import ast.astnode.ASTNode;

public interface Type extends ASTNode {

    Type asArithmetic(Type type, ASTNode node);
    Type asComparison(Type type, ASTNode node);
    Type squareBrackets(Type type, ASTNode node);
    Type castTo(Type type, ASTNode node);
    Type dot(ASTNode node);
    Type asLogical(Type type, ASTNode node);
    Type asNegation(ASTNode node);
    Type asUnaryMinus(ASTNode node);
    Type asBuiltIn(Type type, ASTNode node);
    Type canPromote(Type type, ASTNode node);
    Type asLogical(ASTNode node);
    Type asBuiltIn(ASTNode node);
    Type mustBeCompatible(Type type, ASTNode node);
}
