package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SymbolTable.SymbolTable;


import static org.junit.jupiter.api.Assertions.*;

class IntegerAssignDeclarationNodeTest {
    IntegerAssignDeclarationNode integerAssignDeclarationNode;
    IntNode intNode;
    IdNode idNode;
    SymbolTable symbolTable;

    @BeforeEach
    void setup() {
        intNode = new IntNode(10);
        idNode = new IdNode("pieceCounter");
        integerAssignDeclarationNode = new IntegerAssignDeclarationNode(idNode.name, intNode);
    }

    @Test
    void accept() {
        integerAssignDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        assertEquals(idNode.name, integerAssignDeclarationNode.getLeft().name);
    }

    @Test
    void getRight() {
        assertEquals(intNode, integerAssignDeclarationNode.getRight());
    }


    @Test
    void varName() {
        assertEquals(idNode.name, integerAssignDeclarationNode.varName());
    }

    @Test
    void type() {
        integerAssignDeclarationNode.type();
    }
}