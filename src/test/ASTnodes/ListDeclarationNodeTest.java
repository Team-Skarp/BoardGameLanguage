package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.types.IntType;

import static org.junit.jupiter.api.Assertions.*;

class ListDeclarationNodeTest {
    ListDeclarationNode listDeclarationNode;
    IdNode idNodeList;

    @BeforeEach
    void setup() {
        idNodeList = new IdNode("List", new IntType());
    }

    @Test
    void accept() {
        listDeclarationNode = new ListDeclarationNode(new IntType(), idNodeList);

        listDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getIdentifier() {
        listDeclarationNode = new ListDeclarationNode(new IntType(), idNodeList);

        assertEquals(idNodeList, listDeclarationNode.getIdentifier());
        assertEquals(idNodeList.name, listDeclarationNode.getIdentifier().name);
        assertEquals(idNodeList.type, listDeclarationNode.getIdentifier().type);
    }
}