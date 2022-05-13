package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.SymbolTable;
import SymbolTable.TypeEnvironment;
import SymbolTable.TypeChecker;
import SymbolTable.types.ActionType;
import SymbolTable.types.IntType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionDeclarationNodeTest {
    ActionDeclarationNode fooDcl;
    ActionType fooType;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        TENV = new TypeEnvironment();
        fooType = new ActionType(new IntType(), new IntegerDeclarationNode("Dice"));
        fooDcl = new ActionDeclarationNode("piece", fooType,
                new ListDeclarationNode("redPieces", new IntType()),
                new IntegerDeclarationNode("piece"),
                new StringDeclarationNode("tile"),
                new BooleanDeclarationNode("allowed"));
    }

    @Test
    void accept() {

        fooDcl.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        assertEquals("piece", fooDcl.varName());
    }

    @Test
    void shouldGetTypeOfAction() {
        System.out.println(fooDcl.type());
    }
}