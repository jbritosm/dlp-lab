// Generated from C:/Users/Jusco/IdeaProjects/dlp-lab/src/parser\Pmm.g4 by ANTLR 4.12.0
package parser;

    import ast.astnode.*;
    import ast.definition.*;
    import ast.expression.*;
    import ast.statement.*;
    import ast.type.*;
    import ast.functioninvocation.*;

    import errorhandler.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFunction_arguments(PmmParser.Function_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFunction_arguments(PmmParser.Function_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_parameter_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_parameter_definition(PmmParser.Function_parameter_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_parameter_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_parameter_definition(PmmParser.Function_parameter_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parameter_definition}.
	 * @param ctx the parse tree
	 */
	void enterParameter_definition(PmmParser.Parameter_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parameter_definition}.
	 * @param ctx the parse tree
	 */
	void exitParameter_definition(PmmParser.Parameter_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(PmmParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(PmmParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 */
	void enterType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type_simple}.
	 * @param ctx the parse tree
	 */
	void exitType_simple(PmmParser.Type_simpleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type_complex}.
	 * @param ctx the parse tree
	 */
	void enterType_complex(PmmParser.Type_complexContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type_complex}.
	 * @param ctx the parse tree
	 */
	void exitType_complex(PmmParser.Type_complexContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#void_type}.
	 * @param ctx the parse tree
	 */
	void enterVoid_type(PmmParser.Void_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#void_type}.
	 * @param ctx the parse tree
	 */
	void exitVoid_type(PmmParser.Void_typeContext ctx);
}