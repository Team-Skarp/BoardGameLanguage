package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanEqualsNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    GreaterThanEqualsNode greaterThanEqualsNode;
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(434);
        TENV = new TypeEnvironment();
    }

    @Test
    void acceptsTwoIntsValuesWhenComparing() {
        greaterThanEqualsNode = new GreaterThanEqualsNode(intNodeLeft, intNodeRight);

        greaterThanEqualsNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfOperatorCanCompareTwoIntegers() {
        // Deliberately declared a variable that will give an error at type checking
        booleanNode = new BooleanNode(true);

        greaterThanEqualsNode = new GreaterThanEqualsNode(intNodeLeft, intNodeRight);

        greaterThanEqualsNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }


    @Test
    void greaterThanEqualsNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);

        greaterThanEqualsNode = new GreaterThanEqualsNode(booleanNode, intNodeRight);

        greaterThanEqualsNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> greaterThanEqualsNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}