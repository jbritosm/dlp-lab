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

        valueCGVisitor = new ValueCGVisitor();
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
            cg.pusha(variableDefinition.getOffset());
        } else {
            cg.pushbp();
            cg.push(variableDefinition.getOffset());
            cg.add();
        }

        return null;
    }

    /**
     * address[[ArrayIndexExpression : expression1 -> expression2 expression2]]() = {
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

        cg.push(arrayIndexExpression.getIndexed().getType().numberOfBytes());
        cg.mul();
        cg.add();

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
        cg.push(offset);
        cg.add();

        return null;
    }
}
