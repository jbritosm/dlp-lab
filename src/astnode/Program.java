package astnode;

import definition.Definition;

import java.util.List;

public class Program extends AbstractASTNode {

    private List<Definition> definitions;

    public Program(List<Definition> definitions) {
        super(0, 0);

        this.definitions = definitions;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }
}
