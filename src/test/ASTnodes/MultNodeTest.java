package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class MultNodeTest {
    MultNode multNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
    }

    @Test
    void accept() {
        multNode = new MultNode(intNodeLeft, intNodeRight);

        multNode.accept(new PrettyPrinter());
        multNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void multNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        multNode = new MultNode(booleanNodeLeft, booleanNodeRight);

        multNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> multNode.accept(new TypeChecker(new SymbolTable())));
    }
}