// Generated from C:/Users/Jusco/IdeaProjects/dlp-lab/src/parser\Pmm.g4 by ANTLR 4.12.0
package parser;

    import ast.astnode.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.functioninvocation.*;

    import errorhandler.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_arguments(PmmParser.Function_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_parameter_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_parameter_definition(PmmParser.Function_parameter_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameter_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_definition(PmmParser.Parameter_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(PmmParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type_complex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_complex(PmmParser.Type_complexContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#void_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid_type(PmmParser.Void_typeContext ctx);
}