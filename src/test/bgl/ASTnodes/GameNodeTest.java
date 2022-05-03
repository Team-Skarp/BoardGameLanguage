package ASTnodes;


import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameNodeTest {
    GameNode gameNode;
    BlockNode setup;
    BlockNode rules;
    BlockNode gameLoop;

    @BeforeEach
    void setup() {
        setup = new BlockNode(new StringNode("\"setupBlock\""));
        rules = new BlockNode(new StringNode("\"rulesBlock\""));
        gameLoop = new BlockNode(new StringNode("\"gameLoopBlock\""));
    }

    @Test
    void accept() {
        gameNode = new GameNode(setup, rules, gameLoop);

        gameNode.accept(new PrettyPrinter());
    }
}