package bogac;
import arithm.autogen.*;
import org.antlr.v4.runtime.*;

import java.io.File;

public class ParserTest {

    /*
     *  Simple use of auto-testing the grammer on mulitple input files
     */
    public static void main(String[] args) throws Exception {

        final               File testfolder = new File("src/test/resources/testfiles/bogac");
        CharStream          input;
        ArithmeticLexer     lexer;
        CommonTokenStream   tokens;
        ArithmeticParser    parser;

        for (File testfile : testfolder.listFiles()) {
            input = CharStreams.fromFileName(testfile.getPath());
            lexer = new ArithmeticLexer(input);
            tokens = new CommonTokenStream(lexer);
            parser = new ArithmeticParser(tokens);

            try {
                parser.prog(); // parse the input stream!

                System.out.println("🟢 Successful parse of testfile: " + testfile.getName());
            } catch (RecognitionException error) {
                System.out.println("🔴 Failed parse of testfile: " + testfile.getName());
            }
        }
    };

}
