import ASTnodes.*;

import ASTvisitors.ASTbuilder;
import ASTvisitors.PrettyPrinter;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import Logging.Logger;

import java.util.Locale;

/**
 * Demo file to showcase a pretty print visitor on our AST
 */
public class PrettyPrinterDemo {

    public static void main(String[] args) {
        Logger lo = new Logger();

        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("if(true){}elseif(true){}elseif(true){}else{}");
        lo.g("input: "+input);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        ASTNode ast = getAST(parser,"ifstatement");
        PrettyPrinter pp = new PrettyPrinter();
        ast.accept(pp);
    }

    public static ASTNode getAST(BoardParser parser,String input){
        Logger lo = new Logger();
        input = input.toLowerCase(Locale.ROOT);
        ASTNode ast;
        switch(input){
            case "booleandeclaration":
                BoardParser.BooleanDeclarationContext cstBooleanDeclaration = parser.booleanDeclaration();
                ast = new ASTbuilder().visitBooleanDeclaration(cstBooleanDeclaration);
                lo.g("starting AST at BooleanDeclaration");
                return ast;
            case "arithmeticexpression":
                BoardParser.ArithmeticExpressionContext cstArithmeticExpression = parser.arithmeticExpression();
                ast = new ASTbuilder().visitArithmeticExpression(cstArithmeticExpression);
                lo.g("starting AST at arithmeticExpression");
                return ast;
            case "ifstatement":
                BoardParser.IfStatementContext cstIfStatement = parser.ifStatement();
                ast = new ASTbuilder().visitIfStatement(cstIfStatement);
                lo.g("starting AST at ifStatement");
                return ast;
            case "normalblock":
                BoardParser.NormalBlockContext cstNormalBlock = parser.normalBlock();
                ast = new ASTbuilder().visitNormalBlock(cstNormalBlock);
                lo.g("starting AST at normal block");
                return ast;
            default:
                lo.g("Invalid AST root");
                return null;
        }

    }
}
