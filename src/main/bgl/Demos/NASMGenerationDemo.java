package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import CodeGeneration.NASMCodeGenerator;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;

public class NASMGenerationDemo {
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
                    int a = 5;
                    input(a);
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

        // Assembly x86 - code generation
        NASMCodeGenerator generator = new NASMCodeGenerator();

        // Pass generator to ast
        String code = (String) ast.accept(generator);

        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.asm", false);
            fw.write(code);
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
