package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeErrorException;
import SymbolTable.TypeEnvironment;

import static org.junit.jupiter.api.Assertions.*;

class NegationNodeTest {
    NegationNode negationNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;
    TypeEnvironment TENV;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
        TENV = new TypeEnvironment();
    }

    @Test
    void accept() {
        negationNode = new NegationNode(new BooleanNode(true));

        negationNode.accept(new PrettyPrinter());
        negationNode.accept(new TypeChecker(new SymbolTable(), TENV));
    }

    @Test
    void negationNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        negationNode = new NegationNode(new IntNode(20));

        negationNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> negationNode.accept(new TypeChecker(new SymbolTable(), TENV)));
    }
}