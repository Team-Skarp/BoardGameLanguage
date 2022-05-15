package ASTnodes;


import ASTvisitors.PrettyPrinter;
import SymbolTable.TypeChecker;
import SymbolTable.SymbolTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.TypeEnvironment;
import SymbolTable.types.IntType;

import static org.junit.jupiter.api.Assertions.*;

class ListDeclarationNodeTest {
    ListDeclarationNode listDeclarationNode;
    IdNode idNodeList;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        idNodeList = new IdNode("List");
        TENV = new TypeEnvironment();
        listDeclarationNode = new ListDeclarationNode(idNodeList.name, new IntType());
    }

    @Test
    void accept() {
        listDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void listIdNameMatchesIdNodeUsedInConstructor() {
        assertEquals(idNodeList.name, listDeclarationNode.varName());
    }

    @Test
    void type() {
        listDeclarationNode.type();
    }
}