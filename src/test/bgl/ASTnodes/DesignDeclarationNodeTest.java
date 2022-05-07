package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.types.DesignRef;

import static org.junit.jupiter.api.Assertions.*;

class DesignDeclarationNodeTest {
    DesignDeclarationNode designDeclarationNode;
    DesignRef designRef;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {

        designDeclarationNode = new DesignDeclarationNode("StarTile", "Tile");

        designDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        designDeclarationNode = new DesignDeclarationNode("StarTile", "Tile");

        assertEquals("Tile", designDeclarationNode.varName());
    }

    @Test
    void type() {
        designDeclarationNode = new DesignDeclarationNode("StarTile", "Tile");

        assertEquals("StarTile", designDeclarationNode.ref);
    }
}