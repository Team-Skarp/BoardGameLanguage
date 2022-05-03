package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    GreaterThanNode greaterThanNode;
    BooleanNode booleanNode;

    @Test
    void accept() {
        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(43424);

        greaterThanNode = new GreaterThanNode(intNodeLeft, intNodeRight);

        greaterThanNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfOperatorCanCompareTwoIntegers() {
        // Deliberately declared a variable that will give an error at type checking
        booleanNode = new BooleanNode(true);

        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(3);

        greaterThanNode = new GreaterThanNode(intNodeLeft, intNodeRight);

        greaterThanNode.accept(new TypeChecker(new SymbolTable()));
    }


    @Test
    void greaterThanNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);
        intNodeRight = new IntNode(3);

        greaterThanNode = new GreaterThanNode(booleanNode, intNodeRight);

        greaterThanNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> greaterThanNode.accept(new TypeChecker(new SymbolTable())));
    }
}