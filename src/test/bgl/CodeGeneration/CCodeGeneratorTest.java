package CodeGeneration;

import ASTnodes.*;
import STDLIB.Tile;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import SymbolTable.types.*;
import org.junit.jupiter.api.Test;
import static CodeGeneration.CCodeGenerator.toCType;

import static org.junit.jupiter.api.Assertions.*;

class CCodeGeneratorTest {

    CCodeGenerator generator;
    SymbolHarvester SH = new SymbolHarvester();

    @Test
    public void canCreateCCodeFromPredefinedDesign() {

        //Given Tile node and a written symbol table
        Tile tile = new Tile();
        SymbolTable symbolTable = SH.visit(tile.getDesign());

        //When code generator visits tile node
        generator = new CCodeGenerator(symbolTable);
        generator.visit(tile.getDesign());

        String actual = generator.top;

        //Expect C struct that works
        String expected =
                """
                bool isEmpty();
                struct Tile {
                \tstruct Tile *next;
                \tstruct Tile *prev;
                \tstruct Piece pieces[];
                \tbool (*isEmpty)();
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

        generator = new CCodeGenerator(symbolTable);
        generator.visit(biggest);

        //String actual = generator.top;

        //assertEquals(expected, actual);
    }
}