package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class GreaterThanNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    GreaterThanNode greaterThanNode;
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(43424);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        greaterThanNode = new GreaterThanNode(intNodeLeft, intNodeRight);

        greaterThanNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfOperatorCanCompareTwoIntegers() {
        // Deliberately declared a variable that will give an error at type checking
        booleanNode = new BooleanNode(true);

        greaterThanNode = new GreaterThanNode(intNodeLeft, intNodeRight);

        greaterThanNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }


    @Test
    void greaterThanNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);

        greaterThanNode = new GreaterThanNode(booleanNode, intNodeRight);

        greaterThanNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> greaterThanNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}