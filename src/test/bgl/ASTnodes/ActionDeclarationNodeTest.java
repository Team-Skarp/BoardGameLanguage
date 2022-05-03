package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.types.ActionType;
import SymbolTable.types.IntType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionDeclarationNodeTest {
    ActionDeclarationNode fooDcl;

    @BeforeEach
    void setup() {
        fooDcl = new ActionDeclarationNode("piece", new ActionType(new IntType(), new IntegerDeclarationNode("Dice")),
                new ListDeclarationNode(new IntType(), "redPieces"),
                new IntegerDeclarationNode("piece"),
                new StringDeclarationNode("tile"),
                new BooleanDeclarationNode("allowed"));
    }

    @Test
    void accept() {

        fooDcl.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        assertEquals("piece", fooDcl.varName());
    }

    @Test
    void type() {
        fooDcl.type();
    }
}