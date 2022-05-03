package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class ModNodeTest {
    ModNode modNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        modNode = new ModNode(intNodeLeft, intNodeRight);

        modNode.accept(new PrettyPrinter());
        modNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void modNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        modNode = new ModNode(booleanNodeLeft, booleanNodeRight);

        modNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> modNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}