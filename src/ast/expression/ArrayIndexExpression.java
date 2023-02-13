package ast.expression;

public class ArrayIndexExpression extends AbstractExpression {

    // The part which indexes;
    private Expression indexer;

    // The part being indexed.
    private Expression indexed;

    public ArrayIndexExpression(Expression indexer, Expression indexed, int line, int column) {
        super(line, column);

        this.indexer = indexer;
        this.indexed = indexed;
    }

    public Expression getIndexer() {
        return indexer;
    }

    public Expression getIndexed() {
        return indexed;
    }
}
