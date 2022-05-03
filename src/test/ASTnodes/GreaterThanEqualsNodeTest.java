package ASTnodes;

import ASTvisitors.Evaluator;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanEqualsNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    GreaterThanEqualsNode greaterThanEqualsNode;
    BooleanNode booleanNode;

    @Test
    void acceptsTwoIntsValuesWhenComparing() {
        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(43424);

        greaterThanEqualsNode = new GreaterThanEqualsNode(intNodeLeft, intNodeRight);

        greaterThanEqualsNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfOperatorCanCompareTwoIntegers() {
        // Deliberately declared a variable that will give an error at type checking
        booleanNode = new BooleanNode(true);

        intNodeLeft = new IntNode(2);
        intNodeRight = new IntNode(3);

        greaterThanEqualsNode = new GreaterThanEqualsNode(intNodeLeft, intNodeRight);

        greaterThanEqualsNode.accept(new TypeChecker(new SymbolTable()));
    }


    @Test
    void greaterThanEqualsNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);
        intNodeRight = new IntNode(3);

        greaterThanEqualsNode = new GreaterThanEqualsNode(booleanNode, intNodeRight);

        greaterThanEqualsNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> greaterThanEqualsNode.accept(new TypeChecker(new SymbolTable())));
    }
}