package codegenerator;

import ast.expression.*;
import semantic.AbstractVisitor;

public class ValueCGVisitor extends AbstractVisitor<Void, Void> {

    /**
     * value[[VariableExpression : expression -> ID]]() =
     *     address[[expression]]()
     *     <load> expression.type.suffix()
     */
    @Override
    public Void visit(VariableExpression variableExpression, Void parameter) {
        return null;
    }

    /**
     * value[[ArithmeticComparisonExpression : expression1 -> expression2 ('>'|'>='|'<'|'=<'|'!='|'==') expression3]]() =
     *  value[[expression2]]
     *  expression2.type.convertTo(expression1.type)
     *  value[[expression3]]
     *  expression3.type.convertTo(expression1.type)
     *  switch(expression1.operator) {
     *      case ">": <gt> expression1.type.suffix() break;
     *      case ">=": <ge> expression1.type.suffix() break;
     *      case "<": <lt> expression1.type.suffix() break;
     *      case ">=": <le> expression1.type.suffix() break;
     *      case "==": <eq> expression1.type.suffix() break;
     *      case "!=": <ne> expression1.type.suffix() break;
     *  }
     *
     */
    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Void parameter) {
        return null;
    }

    /**
     * value[[LogicComparisonExpression : expression1 -> expression2 ('&&' | '||') expression3]]() =
     *  value[[expression2]]
     *  expression2.type.convertTo(expression1.type)
     *  value[[expression3]]
     *  expression3.type.convertTo(expression1.type)
     *  switch(expression1.operator) {
     *      case "&&": <and> break;
     *      case "||": <or> break;
     *  }
     */
    @Override
    public Void visit(LogicComparisonExpression logicComparisonExpression, Void parameter) {
        return null;
    }

    /**
     * value[[NotExpression : expression1 -> '!' expression2]]() =
     *  value[[expression2]]
     *  <not>
     */
    @Override
    public Void visit(NotExpression notExpression, Void parameter) {
        return null;
    }

    /**
     * value[[ArithmeticExpression : expression1 -> expression2 ('*'|'/'|'%'|'+'|'-') expression3]]() =
     *  value[[expression2]]
     *  expression2.type.convertTo(exp1.type)
     *  value[[expression3]]
     *  expression3.type.convertTo(exp1.type)
     *  switch(expression1.operator) {
     *      case "+": <add> expression1.type.suffix() break;
     *      case "-": <sub> expression1.type.suffix() break;
     *      case "*": <mul> expression1.type.suffix() break;
     *      case "/": <div> expression1.type.suffix() break;
     *      case "%": <mod> expression1.type.suffix() break;
     *  }
     *
     */
    @Override
    public Void visit(ArithmeticExpression arithmeticExpression, Void parameter) {
        return null;
    }

    /**
     * value[[CastExpression : expression -> type expression]]() =
     *  value[[expression]]
     *
     */
    @Override
    public Void visit(CastExpression castExpression, Void parameter) {
        return null;
    }

    /**
     * value[[IntLiteralExpression : expression -> INT_CONSTANT]]
     *  <pushi> expression.value
     */
    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Void parameter) {
        return null;
    }

    /**
     * value[[RealLiteralExpression : expression -> REAL_CONSTANT]]
     *  <pushf> expression.value
     */
    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Void parameter) {
        return null;
    }

    /**
     * value[[CharLiteralExpression : expression -> CHAR_CONSTANT]]
     *  <pushb> expression.value
     */
    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Void parameter) {
        return null;
    }

    /**
     * value[[UnaryMinusExpression : expression1 -> '-' expression2]]
     *  value[[expression2]]
     *  <push> expression2.type.suffix()
     *  if(expression1.type instanceof IntType)
     *      <pushi> 0
     *  if(expression1.type instanceof RealType)
     *      <pushf> 0.0
     *  <sub> expression1.type.suffix()
     *
     */
    @Override
    public Void visit(UnaryMinusExpression unaryMinusExpression, Void parameter) {
        return null;
    }

}
