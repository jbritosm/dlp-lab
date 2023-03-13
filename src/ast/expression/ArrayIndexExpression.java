package ast.expression;

import visitor.Visitor;

public class ArrayIndexExpression extends AbstractExpression {

    // The part which indexes;
    private Expression indexed;

    // The part being indexed.
    private Expression indexer;

    public ArrayIndexExpression(Expression indexed, Expression indexer, int line, int column) {
        super(line, column);

        this.indexed = indexed;
        this.indexer = indexer;
    }

    public Expression getIndexer() {
        return indexer;
    }

    public Expression getIndexed() {
        return indexed;
    }

    @Override
    public String toString() {
        return "ArrayIndexExpression{" +
                "indexed=" + indexed +
                ", indexer=" + indexer +
                '}';
    }

    @Override
    public <TP, TR> TR accept(Visitor<TP, TR> v, TP parameter) {
        return null;
    }
}
