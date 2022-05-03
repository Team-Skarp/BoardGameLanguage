package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.types.BoolType;

import static org.junit.jupiter.api.Assertions.*;

class BooleanDeclarationNodeTest {
    BooleanDeclarationNode booleanDeclarationNode;
    IdNode idNode;
    BooleanNode booleanNode;

    @Test
    void accept() {
        idNode = new IdNode("boolean", new BoolType());

        booleanDeclarationNode = new BooleanDeclarationNode(idNode, new BooleanNode(false));

        booleanDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {

        /**
         * Mangler dele fra typeChecker
         */
    }

    @Test
    void getIdentifier() {
        booleanNode = new BooleanNode(false);
        idNode = new IdNode("boolean", new BoolType());

        booleanDeclarationNode = new BooleanDeclarationNode(idNode);

        assertEquals(idNode, booleanDeclarationNode.getIdentifier());
        assertEquals(idNode.type, booleanDeclarationNode.getIdentifier().type);
        assertEquals(idNode.name, booleanDeclarationNode.getIdentifier().name);
    }
}