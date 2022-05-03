package ASTnodes;

import ASTnodes.BlockNode;
import ASTnodes.GameNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameNodeTest {
    GameNode gameNode;
    BlockNode setup;
    BlockNode rules;
    BlockNode gameLoop;

    @BeforeEach
    void setup() {
        setup = new BlockNode();
        rules = new BlockNode();
        gameLoop = new BlockNode();
    }

    @Test
    void accept() {

    }
}