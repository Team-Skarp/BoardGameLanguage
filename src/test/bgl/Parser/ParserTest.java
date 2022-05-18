package Parser;

import antlr.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;

public class ParserTest {

    /*
     *  Simple use of auto-testing the grammer on mulitple input files
     */
    public static void main(String[] args) throws Exception {

        final File testfolder = new File("src/test/resources/testfiles/");

        CharStream          input;
        BoardLexer          lexer;
        CommonTokenStream   tokens;
        BoardParser         parser;

        for (File testfile : testfolder.listFiles()) {
            input = CharStreams.fromFileName(testfile.getPath());

            lexer = new BoardLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(SyntaxErrorListener.INSTANCE);

            tokens = new CommonTokenStream(lexer);

            parser = new BoardParser(tokens);
            parser.removeErrorListeners();
            parser.addErrorListener(SyntaxErrorListener.INSTANCE);

            try {
                ParseTree walker = parser.arithmeticExpression(); // parse the input stream!

                System.out.println("🟢 Successful parse of testfile: " + testfile.getName());
            } catch (ParseCancellationException error) {

                System.out.println("🔴 Failed parse of testfile: " + testfile.getName());
                System.out.println("\u001B[31m" + error.getMessage() + "\u001B[0m");
            }
        }
    }

}
