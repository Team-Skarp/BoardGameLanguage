package CodeGeneration;

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
        String code = generator.visit(tile.getDesign());

        //Expect C struct that works
        String expected =
                """
                struct Tile {
                \tstruct Tile *next;
                \tstruct Tile *prev;
                \tstruct Piece pieces[];
                \tbool (*isEmpty)();
                };
                """;

        assertEquals(expected, code);
    }

    @Test
    public void converts_basic_TypeDenoters_to_actual_c_types() {

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
    public void converts_list_types_to_actual_c_types() {

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
}