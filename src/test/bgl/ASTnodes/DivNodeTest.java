package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;


import static org.junit.jupiter.api.Assertions.*;

class DivNodeTest {
    DivNode divNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        divNode = new DivNode(intNodeLeft, intNodeRight);

        divNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfOperatorIsADivision() {
        // Deliberately declared a variable that can give an error at runtime
        booleanNodeRight = new BooleanNode(true);

        divNode = new DivNode(intNodeLeft, intNodeRight);

        divNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void divNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);

        divNode = new DivNode(booleanNodeLeft, booleanNodeRight);

        divNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> divNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}