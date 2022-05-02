import ASTnodes.*;

import ASTvisitors.ASTbuilder;
import CodeGeneration.CCodeGenerator;
import CodeGeneration.Assemblyx86CodeGenerator;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import Logging.Logger;

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
                "" +
                "print(\"hej \",2+5,true and false);" +
                "" +
                "}RULES{}GAMELOOP{}";
        input = CharStreams.fromString(testString);
        lo.g("input: "+input);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        //CCodeGenerator pp = new CCodeGenerator();
        Assemblyx86CodeGenerator pp = new Assemblyx86CodeGenerator();
        String code = (String) ast.accept(pp);
        lo.g("\n"+code);
    }
}
