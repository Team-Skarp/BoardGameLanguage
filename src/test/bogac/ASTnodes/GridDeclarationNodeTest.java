package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;


import static org.junit.jupiter.api.Assertions.*;

class GridDeclarationNodeTest {
    IdNode tile;
    GridDeclarationNode gridDeclarationNode;
    TypeEnvironment TENV;


    @Test
    void accept() {
        tile = new IdNode("Tile");
        gridDeclarationNode = new GridDeclarationNode(tile.name, 8, 8);

        gridDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        tile = new IdNode("Tile");
        gridDeclarationNode = new GridDeclarationNode(tile.name, 8, 8);

        assertEquals(tile.name, gridDeclarationNode.varName());
    }

    @Test
    void type() {
        TENV = new TypeEnvironment();
        tile = new IdNode("Tile");
        gridDeclarationNode = new GridDeclarationNode(tile.name, 8, 8);

        gridDeclarationNode.type();
    }
}