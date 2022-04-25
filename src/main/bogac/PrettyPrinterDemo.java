import ASTnodes.*;

import ASTvisitors.ASTbuilder;
import ASTvisitors.PrettyPrinter;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Demo file to showcase a pretty print visitor on our AST
 */
public class PrettyPrinterDemo {

    public static void main(String[] args) {
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("int a, b = 5 + 5, c;");
        System.out.println(input);

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        //BoardParser.ArithmeticExpressionContext cst = parser.arithmeticExpression();
        //ASTNode ast = new ASTbuilder().visitArithmeticExpression(cst);

        BoardParser.SequentialDeclarationContext cst = parser.sequentialDeclaration();
        ASTNode ast = new ASTbuilder().visitSequentialDeclaration(cst);

        PrettyPrinter pp = new PrettyPrinter();
        ast.accept(pp);
    }
}
