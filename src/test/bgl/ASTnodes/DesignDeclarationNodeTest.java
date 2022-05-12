package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.types.DesignRef;

import static org.junit.jupiter.api.Assertions.*;

class DesignDeclarationNodeTest {
    DesignDeclarationNode designDcl;
    DesignRef designRef;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        TENV = new TypeEnvironment();
        designRef = new DesignRef("StarTile");
    }

    @Test
    void accept() {
        designDcl = new DesignDeclarationNode(designRef.name, "Tile");

        designDcl.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        designDcl = new DesignDeclarationNode(designRef.name, "Tile");

        assertEquals("Tile", designDcl.varName());
    }

    @Test
    void type() {
        designDcl = new DesignDeclarationNode(designRef.name, "Tile");

        designDcl.type();
    }
}