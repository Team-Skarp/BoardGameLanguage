package Demos;

import ASTnodes.*;

import ASTvisitors.ASTbuilder;
import CodeGeneration.Assemblyx86CodeGenerator;
import CodeGeneration.CCodeGenerator;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import Logging.Logger;
import SymbolTable.designs.Tile;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Demo file to showcase a pretty print visitor on our AST
 */
public class CodeGenerationDemo {

    public static void main(String[] args) {
        Logger lo = new Logger();

        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;
        //use this string, starting from gamestart, before pushing any changes. no errors must occur when parsing this string.
        String testString = "SETUP{" +
                "    int a = 0;\n" +
                "    str msg = \"looping!\";\n" +
                "    while(a<5){\n" +
                "        print(a,\" \",msg);\n" +
                "        a = a+1;\n" +
                "    }  " +
                "}RULES{}GAMELOOP{}";

        input = CharStreams.fromString(testString);
        lo.g("input: "+input);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        /* C - code generation */
        //CCodeGenerator pp = new CCodeGenerator();
        //String outputName = "out.c";

        /* Assembly - code generation */
        Assemblyx86CodeGenerator pp = new Assemblyx86CodeGenerator();
        String outputName = "out.asm";

        String code = (String) ast.accept(pp);

        try{
            FileWriter fw = new FileWriter("./src/main/bogac/CodeGeneration/GeneratedFiles/"+outputName,false);
            fw.write(code);
            fw.close();
        }catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }

        lo.g("\n"+code);
    }
}
