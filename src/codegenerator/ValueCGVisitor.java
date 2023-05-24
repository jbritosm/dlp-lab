package codegenerator;

import ast.expression.*;
import ast.type.IntType;
import ast.type.RealType;
import semantic.AbstractVisitor;

public class ValueCGVisitor extends AbstractCGVisitor<Object, Void> {

    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }
    /**
     * value[[VariableExpression : expression -> ID]]() =
     *     address[[expression]]()
     *     <load> expression.type.suffix()
     */
    @Override
    public Void visit(VariableExpression variableExpression, Object parameter) {
        variableExpression.accept(addressCGVisitor, parameter);
        cg.load(variableExpression.getType().getSuffix());

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
     *      case "<=": <le> expression1.type.suffix() break;
     *      case "==": <eq> expression1.type.suffix() break;
     *      case "!=": <ne> expression1.type.suffix() break;
     *  }
     *
     */
    @Override
    public Void visit(ArithmeticComparisonExpression arithmeticComparisonExpression, Object parameter) {
        arithmeticComparisonExpression.getLeft().accept(this, parameter);

        // In our language we can only compare between integers, therefore  we dont need to do
        // the conversion.

        arithmeticComparisonExpression.getRight().accept(this, parameter);

        String suffix = arithmeticComparisonExpression.getType().getSuffix();

        switch (arithmeticComparisonExpression.getOperator()) {
            case ">" -> cg.gt(suffix);
            case ">=" -> cg.ge(suffix);
            case "<" -> cg.lt(suffix);
            case "<=" -> cg.le(suffix);
            case "==" -> cg.eq(suffix);
            default -> cg.ne(suffix);
        }

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
    public Void visit(LogicComparisonExpression logicComparisonExpression, Object parameter) {
        logicComparisonExpression.getLeft().accept(this, parameter);
        logicComparisonExpression.getRight().accept(this, parameter);

        switch (logicComparisonExpression.getOperator()) {
            case "&&" -> cg.and();
            case "||" -> cg.or();
            default -> cg.not();
        }

        return null;
    }

    /**
     * value[[NotExpression : expression1 -> '!' expression2]]() =
     *  value[[expression2]]
     *  <not>
     */
    @Override
    public Void visit(NotExpression notExpression, Object parameter) {
        notExpression.getExpressionToNegate().accept(this, parameter);
        cg.not();

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
    public Void visit(ArithmeticExpression arithmeticExpression, Object parameter) {
        arithmeticExpression.getLeft().accept(this, parameter);
        arithmeticExpression.getRight().accept(this, parameter);

        String suffix = arithmeticExpression.getType().getSuffix();

        switch (arithmeticExpression.getOperator()) {
            case "+" -> cg.add(suffix);
            case "-" -> cg.sub(suffix);
            case "*" -> cg.mul(suffix);
            case "/" -> cg.div(suffix);
            case "%" -> cg.mod(suffix);
        }

        return null;
    }

    /**
     * value[[CastExpression : expression -> type expression]]() =
     *  value[[expression]]
     *
     */
    @Override
    public Void visit(CastExpression castExpression, Object parameter) {
        return null;
    }

    /**
     * value[[IntLiteralExpression : expression -> INT_CONSTANT]]
     *  <pushi> expression.value
     */
    @Override
    public Void visit(IntLiteralExpression intLiteralExpression, Object parameter) {
        cg.push("i", intLiteralExpression.getValue());

        return null;
    }

    /**
     * value[[RealLiteralExpression : expression -> REAL_CONSTANT]]
     *  <pushf> expression.value
     */
    @Override
    public Void visit(RealLiteralExpression realLiteralExpression, Object parameter) {
        cg.pushf(realLiteralExpression.getValue());

        return null;    }

    /**
     * value[[CharLiteralExpression : expression -> CHAR_CONSTANT]]
     *  <pushb> expression.value
     */
    @Override
    public Void visit(CharLiteralExpression charLiteralExpression, Object parameter) {
        cg.push("b", charLiteralExpression.getValue());

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
    public Void visit(UnaryMinusExpression unaryMinusExpression, Object parameter) {
        unaryMinusExpression.getExpression().accept(this, parameter);

        if(unaryMinusExpression.getType() instanceof IntType)
            cg.push("i", 0);
        if(unaryMinusExpression.getType() instanceof RealType)
            cg.pushf(0.0);

        cg.sub(unaryMinusExpression.getType().getSuffix());

        return null;
    }

}
