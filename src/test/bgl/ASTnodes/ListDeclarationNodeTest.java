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
        listDeclarationNode = new ListDeclarationNode(new IntType(), idNodeList.name);
    }

    @Test
    void accept() {
        listDeclarationNode.accept(new PrettyPrinter());
    }

    @Test
    void getIdentifier() {
        listDeclarationNode.accept(new TypeChecker(new SymbolTable(), TENV));
        assertEquals(idNodeList.name, listDeclarationNode.varName());
    }

    @Test
    void type() {
        listDeclarationNode.type();
    }
}