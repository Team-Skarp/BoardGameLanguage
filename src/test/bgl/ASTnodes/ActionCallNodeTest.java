package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.types.DesignRef;
import org.junit.jupiter.api.Test;

class ActionCallNodeTest {
    ActionCallNode fooCall;
    DesignRef designRef;

    @Test
    void shouldAcceptAnyNameWithAnyNumberOfActualParameters() {
        designRef = new DesignRef("SpecialTile");
        fooCall = new ActionCallNode("choice",
                new IntNode(10),
                new BooleanNode(false),
                new StringNode("piece")
        );

        fooCall.accept(new PrettyPrinter());
    }
}