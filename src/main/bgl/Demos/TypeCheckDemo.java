package Demos;

import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeEnvironment;
import SymbolTable.types.TypeDenoter;

public class TypeCheckDemo {

    public static void main(String[] args) {
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        input = CharStreams.fromString("int a;");

        lexer = new BoardLexer(input);
        tokens = new CommonTokenStream(lexer);
        parser = new BoardParser(tokens);

        BoardParser.NormalDeclarationContext cst = parser.normalDeclaration();
        ASTNode ast = new ASTbuilder().visitNormalDeclaration(cst);

        //Give it an empty symbol table and type env
        SymbolTable ST = new SymbolTable();
        TypeEnvironment TENV = new TypeEnvironment();

        TypeChecker typeChecker = new TypeChecker(ST, TENV);
        TypeDenoter resultType = (TypeDenoter) ast.accept(typeChecker);

        System.out.println(resultType.getClass());
    }
}
