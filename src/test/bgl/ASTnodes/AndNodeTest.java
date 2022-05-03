package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;


import static org.junit.jupiter.api.Assertions.*;

class AndNodeTest {
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNodeLeft;
    BooleanNode booleanNodeRight;
    AndNode andNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        TENV = new TypeEnvironment();
        booleanNodeLeft = new BooleanNode(true);
        booleanNodeRight = new BooleanNode(false);
        intNodeLeft = new IntNode(5);
        intNodeRight = new IntNode(3);
    }

    @Test
    void acceptValues() {
        andNode = new AndNode(booleanNodeLeft, booleanNodeRight);

        andNode.accept(new PrettyPrinter());
    }

    @Test
    void typeCheckIfValueIsBoolean() {
        andNode = new AndNode(booleanNodeLeft, booleanNodeRight);

        andNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void andNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        andNode = new AndNode(intNodeLeft, intNodeRight);

        andNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> andNode.accept(new TypeChecker(new SymbolTable(),TENV)));
    }
}