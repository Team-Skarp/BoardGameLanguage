package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.attributes.PrimitiveAttributes;
import symboltable.types.BoolType;
import symboltable.types.IntType;

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
    }

    @Test
    void accept() {
        symbolTable = new SymbolTable().enterSymbol(idNode.name, new PrimitiveAttributes(new IntType()));

        integerAssignDeclarationNode = new IntegerAssignDeclarationNode(idNode, intNode);

        integerAssignDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getLeft() {
        integerAssignDeclarationNode = new IntegerAssignDeclarationNode(idNode, intNode);

        assertEquals(idNode.name, integerAssignDeclarationNode.getLeft().name);
    }

    @Test
    void getRight() {
        integerAssignDeclarationNode = new IntegerAssignDeclarationNode(idNode, intNode);

        assertEquals(idNode.type, integerAssignDeclarationNode.getIdentifier().type);
    }

    @Test
    void getIdentifier() {

    }
}