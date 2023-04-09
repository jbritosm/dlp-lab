package ast.type;

import ast.astnode.ASTNode;
import ast.expression.Expression;

import java.util.List;

public interface Type extends ASTNode {

    String getTypeExpression();
    Type asArithmetic(Type type, ASTNode node);
    Type squareBrackets(Type type, ASTNode node);
    Type castTo(Type type, ASTNode node);
    Type dot(String id, ASTNode node);
    Type asLogical(Type type, ASTNode node);
    Type asLogical(ASTNode node);
    Type asNegation(ASTNode node);
    Type asUnaryMinus(ASTNode node);
    Type asBuiltIn(ASTNode node);
    Type mustBeCompatible(Type type, ASTNode node);
    Type canPromote(Type type, ASTNode node);
    Type checkArgumentTypes(List<Type> types, ASTNode node);
}
