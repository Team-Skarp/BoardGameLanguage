package ASTnodes;

import ASTnodes.BooleanDeclarationNode;
import ASTnodes.BooleanNode;
import ASTnodes.IdNode;
import ASTvisitors.PrettyPrinter;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;


import static org.junit.jupiter.api.Assertions.*;

class BooleanDeclarationNodeTest {
    BooleanDeclarationNode booleanDeclarationNode;
    IdNode idNode;
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        booleanNode = new BooleanNode(false);
        idNode = new IdNode("boolean");
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        idNode = new IdNode("boolean");
        booleanDeclarationNode = new BooleanDeclarationNode(idNode.name, new BooleanNode(false));

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
        booleanDeclarationNode = new BooleanDeclarationNode(idNode.name, booleanNode);

        booleanDeclarationNode.accept(new TypeChecker(new SymbolTable(), TENV));
        assertEquals(idNode.name, booleanDeclarationNode.varName());
    }
}