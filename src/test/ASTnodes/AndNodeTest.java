package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class AndNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;
    AndNode andNode;

    @Test
    void acceptValues() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        andNode = new AndNode(booleanNodeLeft, booleanNodeRight);

        andNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsBoolean() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        andNode = new AndNode(booleanNodeLeft, booleanNodeRight);

        andNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void andNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        intNodeLeft = new IntNode(5);
        intNodeRight = new IntNode(3);

        andNode = new AndNode(intNodeLeft, intNodeRight);

        andNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> andNode.accept(new TypeChecker(new SymbolTable())));
    }
}