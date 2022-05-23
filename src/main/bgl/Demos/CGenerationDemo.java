package Demos;

import ASTnodes.ASTNode;
import CodeGeneration.CCodeGenerator;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ASTvisitors.ASTbuilder;

import java.io.FileWriter;
import java.io.IOException;

public class CGenerationDemo {
    public static void main(String[] args) {

        // Setup
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        /*
        * use this string starting from gamestart, before pushing any changes.
        * no errors must occur when parsing this string.
        */
        String bglCodeExample =
                """
                    SETUP {
                    
                        int z = 5;
                        int h = random(5);
                        int dice = random(6);
                       
                        int a = 1;
                        int c = 6;
                        a = c;
                        a = a + c;
                        
                        design Tile {
                            int ti;
                        }
                        Tile tile;
                        
                        list:list:list:int il4;
                        list:list:list:int il5 = [];
                        
                        bool boo = true;
                                                    
                        list:list:list:int il3 = [[[1],[1]],[[2],[2]],[[3],[3]]];
                        il3[1] = a;
                        a = il3[1];
                        
                        list:int il1 = [11];
                        list:int il2 = [22];
                        
                        list:bool bl1 = [true, false];
                        
                        il1 = il2;
                        
                        print(a);
                        
                    }
                    RULES{
                        action throwDice(int start, int end) :int {
                            return random(end-start+1) +start-1;
                        }
                    }
                    GAMELOOP{
                        a = throwDice(6,12);
                        print(a);
                        print(random(5));
                        print(random(a));
                        print(random(a+5));
                    }
                """;

        // Parse Input
        input   = CharStreams.fromString(bglCodeExample);
        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        // Symmbol harvester
        SymbolHarvester SH = new SymbolHarvester();
        SymbolTable ST = (SymbolTable) ast.accept(SH);

        // C - code generation
        CCodeGenerator generator = new CCodeGenerator(ST, SH.TENV);

        // Pass generator to ast
        String code = (String) ast.accept(generator);
        System.out.println(code);
        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.c",false);
            fw.write(code);
            System.out.println("Compiled successfully");
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
