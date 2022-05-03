package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDeclarationNodeTest {
    IntegerDeclarationNode integerDeclarationNode;
    IdNode idNode;
    IntNode intNode;

    @BeforeEach
    void setup() {
        idNode = new IdNode("pieceCounter", new IntType());
        intNode = new IntNode(100);
    }


    @Test
    void accept() {
        integerDeclarationNode= new IntegerDeclarationNode(idNode, intNode);

        integerDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getIdentifier() {

        integerDeclarationNode = new IntegerDeclarationNode(idNode);

        assertEquals(idNode, integerDeclarationNode.getIdentifier());
        assertEquals(idNode.type, integerDeclarationNode.getIdentifier().type);
        assertEquals(idNode.name, integerDeclarationNode.getIdentifier().name);
    }
}