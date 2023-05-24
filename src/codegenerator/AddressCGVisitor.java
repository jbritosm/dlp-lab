package codegenerator;

import ast.definition.VariableDefinition;
import ast.expression.ArrayIndexExpression;
import ast.expression.FieldAccessExpression;
import ast.expression.VariableExpression;
import ast.type.RecordType;
import semantic.AbstractVisitor;

/*
* Only defined for l-value expressions.
* */
public class AddressCGVisitor extends AbstractCGVisitor<Object, Void> {

    ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        super(cg);
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    /**
     *  address[[Variable : expression -> ID]]() =
     *     if(expression.definition.scope == 0) {
     *         <pusha> expression.definition.offset
     *     } else {
     *         <push> bp
     *         <push> expression.definition.offset
     *         <addi>
     *      }
     */
    @Override
    public Void visit(VariableExpression variableExpression, Object parameter) {
        VariableDefinition variableDefinition = (VariableDefinition) variableExpression.getDefinition();

        if(variableDefinition.getScope() == 0) {
            cg.push("a", variableDefinition.getOffset());
        } else {
            cg.push("bp", 0);
            cg.push("i", variableDefinition.getOffset());
            cg.add("i");
        }

        return null;
    }

    /**
     * address[[ArrayIndexExpression : expression1 -> expression2 expression3]]() = {
     *     address[[expression2]]
     *     value[[expression3]]
     *     <pushi> expression2.type.numberOfBytes
     *     <muli>
     *     <addi>
     * }
     */
    @Override
    public Void visit(ArrayIndexExpression arrayIndexExpression, Object parameter) {
        arrayIndexExpression.getIndexed().accept(this, parameter);
        arrayIndexExpression.getIndexer().accept(valueCGVisitor, parameter);

        cg.push("i", arrayIndexExpression.getType().numberOfBytes());
        cg.mul("i");
        cg.add("i");

        return null;
    }

    /**
     * address[[FieldAccessExpression : expression1 -> expression2 ID]]() = {
     *     address[[expression2]]
     *
     *     int offset = expression2.getField(ID).offset
     *
     *     <pushi> offset
     *     <addi>
     *
     * }
     */
    @Override
    public Void visit(FieldAccessExpression fieldAccessExpression, Object parameter) {
        RecordType record = (RecordType) fieldAccessExpression.getAccessed().getType();

        fieldAccessExpression.getAccessed().accept(this, parameter);
        int offset = record.getField(fieldAccessExpression.getName()).getOffset();
        cg.push("i", offset);
        cg.add("i");

        return null;
    }
}
