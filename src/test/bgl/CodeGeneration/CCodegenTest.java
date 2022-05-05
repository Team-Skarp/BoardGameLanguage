package CodeGeneration;

import STDLIB.Tile;
import SymbolTable.SymbolTable;
import SymbolTable.SymbolHarvester;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CCodegenTest {

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

}
