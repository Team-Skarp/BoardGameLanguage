package ASTnodes;

import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WhileNodeTest {
    WhileNode whileNode;
    PredicateNode predicateNodeTrue;
    PredicateNode predicateNodeFalse;
    BlockNode blockNodeWhile;

    @BeforeEach
    void setup() {
        predicateNodeTrue = new PredicateNode(new BooleanNode(true));
        predicateNodeFalse = new PredicateNode(new BooleanNode(false));
        blockNodeWhile = new BlockNode("whileBlock");
    }

    @Test
    void accept() {
        whileNode = new WhileNode(predicateNodeFalse, blockNodeWhile);

        whileNode.accept(new PrettyPrinter())
    }
}