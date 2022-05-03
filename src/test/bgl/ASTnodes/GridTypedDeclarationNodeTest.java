package ASTnodes;
;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class GridTypedDeclarationNodeTest {
    GridTypedDeclarationNode gridTypedDeclarationNode;
    IdNode tile;
    TypeEnvironment TENV;

    @Test
    void accept() {
        tile = new IdNode("Board");
        gridTypedDeclarationNode = new GridTypedDeclarationNode(tile.name, "SpecialTile",8, 8);

        gridTypedDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        tile = new IdNode("Tile");
        gridTypedDeclarationNode = new GridTypedDeclarationNode(tile.name, "SpecialTile", 8, 8);

        assertEquals(tile.name, gridTypedDeclarationNode.varName());
    }

    @Test
    void type() {
        TENV = new TypeEnvironment();
        tile = new IdNode("Tile");
        gridTypedDeclarationNode = new GridTypedDeclarationNode(tile.name, "SpecialTile", 8, 8);

        gridTypedDeclarationNode.type();
    }
}