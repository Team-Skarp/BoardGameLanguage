package ASTnodes;

import ASTvisitors.PrettyPrinter;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionDefinitionNodeTest {
    ActionDefinitionNode fooDef;
    ActionDeclarationNode fooDcl;
    ParameterBlock fooBody;

    @BeforeEach
    void setup() {
        fooBody = new ParameterBlock(
                new IntegerDeclarationNode("a"),
                new BooleanDeclarationNode("b")
        );

        fooDcl = new ActionDeclarationNode("OnLand", new BoolType(),
                new IntegerDeclarationNode("rollTries"),
                new BooleanDeclarationNode("stopTurn")
        );

    }

    @Test
    void accept() {
        fooDef = new ActionDefinitionNode("starTile", new IntType(), fooBody, fooDcl);

        fooDef.accept(new PrettyPrinter());
    }

    @Test
    void varName() {
        fooDef = new ActionDefinitionNode("starTile", new IntType(), fooBody, fooDcl);

        assertEquals(fooDef.name, fooDef.varName());
    }

    @Test
    void type() {
        fooDef = new ActionDefinitionNode("starTile", new IntType(), fooBody, fooDcl);

        fooDef.type();
    }
}