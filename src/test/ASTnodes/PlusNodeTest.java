package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class PlusNodeTest {
    PlusNode plusNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        booleanNodeRight = new BooleanNode(false);
    }

    @Test
    void accept() {
        plusNode = new PlusNode(intNodeLeft, intNodeRight);

        plusNode.accept(new PrettyPrinter());
    }

    @Test
    void TypeChecksVariable() {
        plusNode = new PlusNode(intNodeLeft, intNodeRight);

        plusNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void plusNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        plusNode = new PlusNode(intNodeLeft, booleanNodeRight);

        assertThrows(TypeErrorException.class, () -> plusNode.accept(new TypeChecker(new SymbolTable())));
    }

    @Test
    void getLeft() {
        plusNode = new PlusNode(intNodeLeft, intNodeRight);

        assertEquals(intNodeLeft, plusNode.getLeft());
    }

    @Test
    void getRight() {
        plusNode = new PlusNode(intNodeLeft, intNodeRight);

        assertEquals(intNodeRight, plusNode.getRight());
    }
}