package ASTnodes;

import ASTnodes.*;
import ASTvisitors.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalNodeTest {
    ConditionalNode conditionalNode;
    ElifConditionalNode elifConditionalNode;
    PredicateNode predicateNodeTrue;
    PredicateNode predicateNodeFalse;
    BlockNode blockNodeIf;
    List<ASTNode> blockNodeElseIfList;
    BlockNode BlockNodeElseIf;
    BlockNode blockNodeElse;

    @BeforeEach
    void setup() {
        predicateNodeTrue = new PredicateNode(new BooleanNode(true));
        predicateNodeFalse = new PredicateNode(new BooleanNode(false));
    }

    @Test
    void acceptsOnlyIfStatement() {
        elifConditionalNode = new ElifConditionalNode();
        blockNodeIf = new BlockNode();

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf);
        conditionalNode.accept(new PrettyPrinter());
    }

    @Test
    void acceptsIfAndElseStatements() {
        blockNodeIf = new BlockNode();
        blockNodeElse = new BlockNode();

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElse);

        conditionalNode.accept(new PrettyPrinter());
    }


    @Test
    void acceptsIfAndAListOfElifStatements() {
        blockNodeIf = new BlockNode();
        blockNodeElseIfList = new ArrayList<>();

        BlockNodeElseIf = new BlockNode();
        blockNodeElseIfList.add(BlockNodeElseIf);

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElseIfList);

        conditionalNode.accept(new PrettyPrinter());
        assertEquals(1, blockNodeElseIfList.size());
    }

    @Test
    void acceptsIfAndAListOfElifAndElseStatements() {
        blockNodeIf = new BlockNode();
        blockNodeElse = new BlockNode();
        blockNodeElseIfList = new ArrayList<>();

        BlockNodeElseIf = new BlockNode();
        blockNodeElseIfList.add(BlockNodeElseIf);

        conditionalNode = new ConditionalNode(predicateNodeTrue, blockNodeIf, blockNodeElseIfList, blockNodeElse);

        conditionalNode.accept(new PrettyPrinter());
        assertEquals(1, blockNodeElseIfList.size());
    }
}