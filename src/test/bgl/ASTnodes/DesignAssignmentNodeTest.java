package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.types.ActionType;
import SymbolTable.types.IntType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesignAssignmentNodeTest {
    DesignAssignmentNode designAssignmentNode;
    IdNode idNode;
    IntegerDeclarationNode integerDcl;
    BooleanDeclarationNode booleanDcl;
    ActionDeclarationNode fooDcl;
    ActionType fooType;
    DesignDeclarationNode designDcl;

    @BeforeEach
    void setup() {
        idNode = new IdNode("piece");
        integerDcl = new IntegerDeclarationNode("dice", new IntNode(6));
        booleanDcl = new BooleanDeclarationNode("win", new BooleanNode(false));
        fooType = new ActionType(new IntType(), new IntegerDeclarationNode("Dice"));
        fooDcl = new ActionDeclarationNode("piece", fooType,
                new ListDeclarationNode("redPieces", new IntType()),
                new IntegerDeclarationNode("piece"),
                new StringDeclarationNode("tile"),
                new BooleanDeclarationNode("allowed"));
        designDcl = new DesignDeclarationNode("StarTile", "Tile");

    }

    @Test
    void shouldAcceptAListOfDeclarationInsideDesignAssigment() {
        designAssignmentNode = new DesignAssignmentNode(idNode, integerDcl, booleanDcl, fooDcl);
        designAssignmentNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        designAssignmentNode = new DesignAssignmentNode(idNode, integerDcl, booleanDcl, fooDcl);
        assertEquals(idNode, designAssignmentNode.getLeft());
    }

    @Test
    void getRight() {
        designAssignmentNode = new DesignAssignmentNode(idNode, integerDcl, booleanDcl, fooDcl);
        //assertEquals(designAssignmentNode.fields, designAssignmentNode.getRight());
    }
}