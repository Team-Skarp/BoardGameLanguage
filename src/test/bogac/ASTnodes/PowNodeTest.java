package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class PowNodeTest {
    PowNode powNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(3);
        booleanNodeRight = new BooleanNode(false);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        powNode = new PowNode(intNodeLeft, intNodeRight);

        powNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {
        powNode = new PowNode(intNodeLeft, intNodeRight);

        powNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void plusNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        powNode = new PowNode(intNodeLeft, booleanNodeRight);

        assertThrows(TypeErrorException.class, () -> powNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}