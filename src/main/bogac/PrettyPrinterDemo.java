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
        input = CharStreams.fromString("str a = \"hej\",b,c;");
        lo.g("input: "+input);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        ASTNode ast = getAST(parser,"decl");
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
            case "aexpr":
                BoardParser.ArithmeticExpressionContext cstArithmeticExpression = parser.arithmeticExpression();
                ast = new ASTbuilder().visitArithmeticExpression(cstArithmeticExpression);
                lo.g("starting AST at arithmeticExpression");
                return ast;
            case "bexpr":
                BoardParser.BooleanExpressionContext cstbexpr = parser.booleanExpression();
                ast = new ASTbuilder().visitBooleanExpression(cstbexpr);
                lo.g("starting AST at boolean expression");
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
            case "statements":
                BoardParser.StatementsContext cststatements = parser.statements();
                ast = new ASTbuilder().visitStatements(cststatements);
                lo.g("starting AST at statements");
                return ast;
            case "while":
                BoardParser.WhileStatementContext cstwhile = parser.whileStatement();
                ast = new ASTbuilder().visitWhileStatement(cstwhile);
                lo.g("starting AST at while");
                return ast;
            case "decl":
                BoardParser.NormalDeclarationContext cstdecl = parser.normalDeclaration();
                ast = new ASTbuilder().visitNormalDeclaration(cstdecl);
                lo.g("starting AST at normal decl");
                return ast;
            case "print":
                BoardParser.PrintContext cstprint = parser.print();
                ast = new ASTbuilder().visitPrint(cstprint);
                lo.g("starting AST at print");
                return ast;
            default:
                lo.g("Invalid AST root");
                return null;
        }

    }
}
