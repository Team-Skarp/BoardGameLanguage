package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import CodeGeneration.Assemblyx86CodeGenerator;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileWriter;
import java.io.IOException;

public class AsmGenerationDemo {
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
                    int a = 0;
                    str msg = "looping!";
                    
                    while(a<5){
                        print(a," ",msg);
                        a = a + 1;
                    }
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
        Assemblyx86CodeGenerator generator = new Assemblyx86CodeGenerator();

        // Pass generator to ast
        String code = (String) ast.accept(generator);

        try {
            FileWriter fw = new FileWriter("./src/main/bogac/CodeGeneration/GeneratedFiles/out.asm", false);
            fw.write(code);
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }
}
