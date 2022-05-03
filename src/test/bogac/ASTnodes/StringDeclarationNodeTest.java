package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class StringDeclarationNodeTest {
    StringDeclarationNode stringDeclarationNode;
    IdNode idNode;
    TypeEnvironment TENV = new TypeEnvironment();

    @BeforeEach
    void setup() {
        idNode = new IdNode("tile");
    }

    @Test
    void acceptStringDeclarationNodeWithOnlyIdNode() {
        stringDeclarationNode = new StringDeclarationNode(idNode.name);

        stringDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptStringDeclarationNodeWithIdNodeAndValue() {
        stringDeclarationNode = new StringDeclarationNode(idNode.name, new StringNode("specialTile"));

        stringDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        stringDeclarationNode = new StringDeclarationNode(idNode.name);

        assertEquals(idNode.name, stringDeclarationNode.name);
    }

    @Test
    void type() {
        stringDeclarationNode = new StringDeclarationNode(idNode.name);

        stringDeclarationNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }
}