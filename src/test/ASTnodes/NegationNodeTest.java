package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import symboltable.SymbolTable;
import symboltable.TypeChecker;
import symboltable.TypeErrorException;

import static org.junit.jupiter.api.Assertions.*;

class NegationNodeTest {
    NegationNode negationNode;
    IntNode intNodeLeft;
    IntNode intNodeRight;

    @BeforeEach
    void setup() {
        intNodeLeft = new IntNode(50);
        intNodeRight = new IntNode(25);
    }

    @Test
    void accept() {
        negationNode = new NegationNode(new BooleanNode(true));

        negationNode.accept(new PrettyPrinter());
        negationNode.accept(new TypeChecker(new SymbolTable()));
    }

    @Test
    void negationNodeShouldThrowAnExceptionBecauseOfWrongTypeInputs() {
        negationNode = new NegationNode(new IntNode(20));

        negationNode.accept(new PrettyPrinter());
        assertThrows(TypeErrorException.class, () -> negationNode.accept(new TypeChecker(new SymbolTable())));
    }
}