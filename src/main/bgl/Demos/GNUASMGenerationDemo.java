package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import CodeGeneration.GNUASMCodeGenerator;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;

public class GNUASMGenerationDemo {
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
        String bglCodeExample = """
                SETUP {
                    bool c = (2>=1 or 2<=1) and !(true and false) and (2==2)and(3>2);
                    int a = 2*2+5;
                    print(c,a," sooo cool");
                }
                
                RULES{}
                GAMELOOP{}
                """;


        // Parse Input
        input = CharStreams.fromString(bglCodeExample);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);



        // Symmbol harvester
        SymbolHarvester SH = new SymbolHarvester();
        SymbolTable ST = (SymbolTable) ast.accept(SH);

        // GNU GAS assembly - code generation
        GNUASMCodeGenerator generator = new GNUASMCodeGenerator(ST);

        // Pass generator to ast
        String code = (String) ast.accept(generator);
        System.out.println(code);
        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.s", false);
            fw.write(code);
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
