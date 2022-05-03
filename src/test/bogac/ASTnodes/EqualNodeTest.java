package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;


import static org.junit.jupiter.api.Assertions.*;

class EqualNodeTest {
    EqualNode equalNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    BooleanNode booleanNode;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        booleanNode = new BooleanNode(false);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        equalNode = new EqualNode(intNodeLeft, intNodeRight);

        equalNode.accept(new PrettyPrinter());
    }

    @Test
    void typeChecksIfTwoOperatorsIsTwoOfTheSame() {
        // Deliberately declared a variable that will give an error at runtime
        booleanNode = new BooleanNode(true);

        intNodeLeft = new IntNode(522);
        intNodeRight = new IntNode(3);

        equalNode = new EqualNode(intNodeLeft, intNodeRight);

        equalNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }


    @Test
    void equalNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        booleanNode = new BooleanNode(true);

        equalNode = new EqualNode(booleanNode, intNodeRight);

        equalNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> equalNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}