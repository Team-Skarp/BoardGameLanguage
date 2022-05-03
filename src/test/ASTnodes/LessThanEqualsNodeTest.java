package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class LessThanEqualsNodeTest {
    LessThanEqualsNode lessThanEqualsNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNode;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(10);
        intNodeRight = new IntNode(50);
    }

    @Test
    void accept() {
        // Deliberately declared a variable that will give an error at type checking
        booleanNode = new BooleanNode(true);

        lessThanEqualsNode = new LessThanEqualsNode(intNodeLeft, intNodeRight);

        lessThanEqualsNode.accept(new PrettyPrinter());
    }

    @Test
    void lessThanEqualsNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        lessThanEqualsNode = new LessThanEqualsNode(booleanNodeLeft, booleanNodeRight);

        lessThanEqualsNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> lessThanEqualsNode.accept(new TypeChecker(new SymbolTable())));
    }
}