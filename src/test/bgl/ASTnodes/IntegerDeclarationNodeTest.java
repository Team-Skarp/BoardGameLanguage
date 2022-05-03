package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.TypeChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class IntegerDeclarationNodeTest {
    IntegerDeclarationNode integerDeclarationNode;
    IdNode idNode;
    IntNode intNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        idNode = new IdNode("pieceCounter");
        intNode = new IntNode(100);
        TENV = new TypeEnvironment();
    }


    @Test
    void accept() {
        integerDeclarationNode= new IntegerDeclarationNode(idNode.name, intNode);

        integerDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getIdentifier() {

        integerDeclarationNode = new IntegerDeclarationNode(idNode.name);

        integerDeclarationNode.accept(new TypeChecker(new SymbolTable(), TENV));
        assertEquals(idNode.name, integerDeclarationNode.varName());
    }
}