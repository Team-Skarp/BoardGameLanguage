package CodeGeneration;

import ASTnodes.*;
import STDLIB.Piece;
import STDLIB.PredefinedDesign;
import STDLIB.Tile;
import SymbolTable.TypeEnvironment;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import SymbolTable.Symbol;
import SymbolTable.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static CodeGeneration.CCodeGenerator.toCType;

import static org.junit.jupiter.api.Assertions.*;

class CCodeGeneratorTest {

    CCodeGenerator generator;
    TypeEnvironment TENV;
    SymbolHarvester SH;

    @BeforeEach
    void setup() {
        SH = new SymbolHarvester();
        TENV = new TypeEnvironment();
    }

    @Test
    public void canCreateCCodeFromPredefinedDesign() {

        //Given Tile node and a written symbol table
        Tile tile = new Tile();
        SymbolTable symbolTable = SH.visit(tile.getDesign());
        symbolTable.resetScopePointers();
        //symbolTable.enterSymbol(new Symbol("pieces", new ListType(new Piece().getType())));

        //When code generator visits tile node
        generator = new CCodeGenerator(symbolTable, SH.TENV);
        generator.visit(tile.getDesign());

        String actual = generator.definitions;

        System.out.println(actual);

        //Expect C struct that works
        String expected =
                    """
                    struct Tile {
                    \tbool back_track_allowed;
                    \tint p_count;
                    \tstruct Tile *next;
                    \tstruct Tile *prev;
                    };
                    """;

        assertEquals(expected, actual);
    }

    @Test
    public void convertBasicTypeDenotersToActualCTypes() {

        IntType     intType     = new IntType();
        StringType  stringType  = new StringType();
        BoolType    boolType    = new BoolType();
        DesignRef   designType  = new DesignRef("TestType");
        VoidType    voidType    = new VoidType();

        assertEquals("int", toCType(intType));
        assertEquals("char*", toCType(stringType));
        assertEquals("bool", toCType(boolType));
        assertEquals("struct TestType", toCType(designType));
        assertEquals("void", toCType(voidType));
    }

    @Test
    public void convertsListTypesToActualCTypes() {

        //Given
        ListType intList    = new ListType(new IntType());
        ListType strList    = new ListType(new StringType());
        ListType boolList   = new ListType(new BoolType());
        ListType designList = new ListType(new DesignRef("TestType"));
        ListType intArray3D = new ListType(new ListType(new ListType(new IntType())));

        assertEquals("int*", toCType(intList));
        assertEquals("char**", toCType(strList));
        assertEquals("bool*", toCType(boolList));
        assertEquals("struct TestType*", toCType(designList));
        assertEquals("int***", toCType(intArray3D));
    }

    @Test
    /**
     * Tests the code:
     * action biggest(int a, int b) : int {
     *     if (a < b) {
     *         return b;
     *     }
     *     return a;
     * }
     */
    public void generatesCorrectCCodeForActions() {

        ActionDefinitionNode biggest = new ActionDefinitionNode(
                "biggest",
                new IntType(),
                new ParameterBlock(
                        new ConditionalNode(
                                new LessThanNode(
                                        new IdNode("a"),
                                        new IdNode("b")
                                ),
                                new BlockNode(
                                        new ReturnNode(
                                                new IdNode("b")
                                        )
                                )
                        ),
                        new ReturnNode(
                                new IdNode("b")
                        )

                ),
                new IntegerDeclarationNode(
                        "a"
                ),
                new IntegerDeclarationNode(
                        "b"
                )
        );

        String expected = """
                          int biggest(int a, int b) {
                            if (a < b) {
                                return b;
                            }
                            return a;
                          }
                          """;

        SH = new SymbolHarvester();
        SymbolTable symbolTable = SH.visit(biggest);
        symbolTable.resetScopePointers();

        generator = new CCodeGenerator(symbolTable, TENV);
        generator.visit(biggest);

        //String actual = generator.top;

        //assertEquals(expected, actual);
    }

    /**
     * Tests the code:
     * design Dog {
     *     action woof();
     * }
     * Dog bulldog;
     */
    @Test
    public void generatesCCodeForDesignAction() {
        SymbolTable ST = new SymbolTable();
        TENV = new TypeEnvironment();

        TENV.enterType(
                new DesignType(
                        "Dog",
                        new SymbolTable().enterSymbol(
                                new Symbol(
                                        "woof",
                                        new ActionType(
                                                new VoidType()
                                        )
                                )
                        )
                )
        );

        ST.enterSymbol(
                new Symbol(
                        "bulldog",
                        new DesignRef("Dog")
                )
        );

        DesignDeclarationNode bulldog = new DesignDeclarationNode(
                "Dog",
                "bulldog"
        );

        //When code generator visits tile node
        generator = new CCodeGenerator(ST, TENV);
        generator.visit(bulldog);

        String actual = generator.visit(bulldog);

        //Expect C struct that works
        String expected =
                """
                struct Dog bulldog;
                bulldog.woof = &woof;
                
                """;

        assertEquals(expected.strip(), actual.strip());
    }

    /**
     * design Dog {
     *     action bark();
     * }
     * action bark(Dog self) {} <-- should be classified as method of Dog design
     */
    @Test
    public void correctlyIdentifiesAnActionAsMethodOfDesign() {

        SH = new SymbolHarvester();

        DesignDefinitionNode Dog = new DesignDefinitionNode(
                "Dog",
                new ActionDeclarationNode(
                        "bark",
                        new VoidType()
                )
        );
        ActionDefinitionNode bark = new ActionDefinitionNode(
                "bark",
                new VoidType(),
                new ParameterBlock(),
                new DesignDeclarationNode(
                        "Dog", // <-- Takes the Dog design as first argument
                        "self"
                )
        );
        NonScopeBlockNode block = new NonScopeBlockNode(
                Dog,
                bark
        );

        SymbolTable generatedST = SH.visit(block);
        generatedST.resetScopePointers();
        CCodeGenerator generator = new CCodeGenerator(generatedST, SH.TENV);
        generator.visit(block);

        String expectedDefinition =
                """
                void bark(struct Dog *self);
                """;

        assertEquals(expectedDefinition, generator.prototypes);
    }
}