package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class LessThanNodeTest {
    LessThanNode lessThanNode;
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
        lessThanNode = new LessThanNode(intNodeLeft, intNodeRight);

        lessThanNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfBothValueIsInt() {
        // Deliberately declared a variable that will give an error at runtime
        booleanNode = new BooleanNode(true);

        lessThanNode = new LessThanNode(intNodeLeft, intNodeRight);

        lessThanNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void lessThanNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        lessThanNode = new LessThanNode(booleanNodeLeft, booleanNodeRight);

        lessThanNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> lessThanNode.accept(new TypeChecker(new SymbolTable())));
    }
}