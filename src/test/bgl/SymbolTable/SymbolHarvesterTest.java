package SymbolTable;

import ASTnodes.*;
import org.junit.Test;

import SymbolTable.types.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SymbolHarvesterTest {

    SymbolHarvester symbolHarvester;

    /**
     * Tests the code;
     * int a, b;
     */
    @Test
    public void entersSequentialIntegerDeclarationCorrectly() {


        symbolHarvester = new SymbolHarvester();

        SequentialDeclaration sequence = new SequentialDeclaration(
                new IntType(),
                new IntegerDeclarationNode("a"),
                new IntegerDeclarationNode("b")
        );

        symbolHarvester.visit(sequence);
    }

    /**
     * Tests the code:
     * int a, b = false
     */
    @Test
    public void should_throw_typeerror_when_expression_type_does_not_match_in_sequence_declaration() {

        symbolHarvester = new SymbolHarvester();

        SequentialDeclaration sequence = new SequentialDeclaration(
                new IntType(),
                new IntegerDeclarationNode("a"),
                new IntegerDeclarationNode(
                        "b",
                        new BooleanNode(false)
                )
        );


        assertThrows(TypeErrorException.class, () -> symbolHarvester.visit(sequence));

    }

    @Test
    public void can_enter_design_definition_into_symbol_table() {       //design Player {str name;}

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode playerDefinition = new DesignDefinitionNode(
                new IdNode("Player"),
                new StringDeclarationNode("name")
        );

        symbolHarvester.visit(playerDefinition);

    }

    @Test
    public void can_define_design_with_design_field() {       //design Player {Color color;}

        symbolHarvester = new SymbolHarvester();

        DesignDefinitionNode Color = new DesignDefinitionNode(
                new IdNode("Color"),
                new StringDeclarationNode("name")
        );

        DesignDefinitionNode Player = new DesignDefinitionNode(
                new IdNode("Player"),
                new DesignDeclarationNode(
                        "Color",
                        "color")
        );

        symbolHarvester.visit(Color);
        symbolHarvester.visit(Player);

    }

    /**
     * Tests the code:
     * a -> {                #Variable a have been passed down to this block
     *     int a;       #should fail to redeclare
     * }
     */
    @Test
    public void should_throw_error_when_redeclaring_variable_from_parameterized_block() {

        symbolHarvester = new SymbolHarvester();

        ParameterBlock parameterBlock = new ParameterBlock(
                new IntegerDeclarationNode("a")
        );

        parameterBlock.variables = List.of(new Symbol(
                "a",
                new IntType())
        );

        assertThrows(DuplicateSymbolException.class, () ->
                symbolHarvester.visit(parameterBlock));

    }

}
