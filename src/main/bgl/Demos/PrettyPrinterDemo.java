package Demos;

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
        //use this string, starting from gamestart, before pushing any changes. no errors must occur when parsing this string.
        String completeGameStringTestBeforePushingToGit = "SETUP{while(a > 2){if(!(2==-3)){if(2-2*3!=b){bool a,b=true,c=true and false,d;a = \"hej\"; b = 2; c = false;}elseif(!c){input(testinput);str a = \"hej\",b,c=\":D\";}else{int a = 2*2,b = a*2^2,c;}}else{foreach(car in garage){bool car = 2;}}}}RULES{print(5,\"cars in the\",garage);}GAMELOOP{while(true){print(2*2+2);}}";
        String testString = "SETUP{a.b = false && true;}RULES{}GAMELOOP{exit;}";
        input = CharStreams.fromString(testString);
        lo.g("input: "+input);
        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        ASTNode ast = getAST(parser,"game");
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
                BoardParser.StatementContext cststatement = parser.statement();
                ast = new ASTbuilder().visitStatement(cststatement);
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
            case "setup":
                BoardParser.SetupContext cstsetup = parser.setup();
                ast = new ASTbuilder().visitSetup(cstsetup);
                lo.g("starting AST at setup");
                return ast;
            case "game":
                BoardParser.GameContext cstgame = parser.game();
                ast = new ASTbuilder().visitGame(cstgame);
                lo.g("starting AST at game");
                return ast;
            default:
                lo.g("Invalid AST root");
                return null;
        }

    }
}
