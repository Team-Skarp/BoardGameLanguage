package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;

class ActionBodyNodeTest {
    ActionBodyNode fooBody;

    /**
     * **foo()** {int a, bool b}
     */
    @Test
    void accept() {
        fooBody = new ActionBodyNode(
                new IntegerDeclarationNode("a"),
                new BooleanDeclarationNode("b"));

        fooBody.accept(new PrettyPrinter());
    }
}