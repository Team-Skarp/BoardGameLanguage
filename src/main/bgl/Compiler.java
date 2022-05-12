import ASTnodes.ASTNode;
import ASTvisitors.ASTbuilder;
import ASTvisitors.ASTvisitor;
import CodeGeneration.CCodeGenerator;
import CodeGeneration.GNUASMCodeGenerator;
import STDLIB.STDLIBC;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compiler {


    private static String handleFileNaming(List<String> args) {
        String outputFileName;

        // check for "-o" flag
        if (args.contains("-o")) {
            outputFileName = args.get(args.indexOf("-o")+1);
        } else {
            if (args.contains("-asm")) {
                outputFileName = "out.asm";
            } else {
                outputFileName = "out.c";
            }

        }
        return outputFileName;
    }

    private static String handleFilePath(List<String> args) {
        String inputFilePath = "";
        for (String arg: args) {
            if (arg.contains(".bgl")) {
                inputFilePath = arg;
            }
        }

        return inputFilePath;
    }

    private static ASTvisitor getCodeGenerator(List<String> args, SymbolTable ST, SymbolHarvester SH) {
        // C code generation - specified
        if (args.contains("-c")) {
            return new CCodeGenerator(ST, SH.TENV);
        }
        // Assembly code generation
        else if (args.contains("-asm")) {
            return new GNUASMCodeGenerator(ST);
        }
        // Defaulting to C code generation and default name
        else {
            return new CCodeGenerator(ST, SH.TENV);
        }
    }

    private static void writeSTDLIB(ASTvisitor generator) {
        try {
            FileWriter fw = new FileWriter(
                    "./src/main/bgl/BglFiles/Generated/bgllib.h",
                    false
            );
            fw.write(STDLIBC.imports);
            fw.write(STDLIBC.defines);
            if (generator instanceof CCodeGenerator ccg) {
                fw.write(ccg.definitions);
            }
            fw.close();

            System.out.println("Compiled successfully");
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }
    }

    public static void main(String[] args) throws IOException {

        // Setup
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;
        List<String> arguments = List.of(args);

        // Created AST from vist STD
        ASTNode stdAST = STDLIBC.getAST();

        // STDLIB Symbol Harvester
        SymbolHarvester stdSH= new SymbolHarvester();
        SymbolTable stdST = (SymbolTable) stdAST.accept(stdSH);

        // STDLIB Code generator
        ASTvisitor stdGenerator = getCodeGenerator(arguments, stdST, stdSH);

        // STDLIB COde
        stdAST.accept(stdGenerator);
        writeSTDLIB(stdGenerator);

        // User code generation
        StringBuilder userCode = new StringBuilder();


        try(BufferedReader reader = new BufferedReader(new FileReader(handleFilePath(arguments)))) {
            List<String> productList = reader.lines().toList();
            for (String str: productList) {
                userCode.append(str);
            }
        } catch (IOException e) {
            throw new IOException("No such file found: %s".formatted(handleFilePath(arguments)));
        }

        // Parse Input
        input   = CharStreams.fromString(userCode.toString());
        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        // Symbol harvester
        SymbolHarvester SH = new SymbolHarvester(stdST, stdSH.TENV);
        SymbolTable ST = (SymbolTable) ast.accept(SH);

        // Generator and file naming
        ASTvisitor generator = getCodeGenerator(arguments, ST, SH);
        String outputFileName = handleFileNaming(arguments);

        // Pass generator to ast
        String code = (String) ast.accept(generator);

        try {
            FileWriter fw = new FileWriter(
                    "./src/main/bgl/BglFiles/Generated/%s".formatted(outputFileName),
                    false
            );
            fw.write(code);
            System.out.println("Compiled successfully");
            fw.close();
        } catch (IOException ex) {
            // Print message as exception occurred when
            // invalid path of local machine is passed
            System.out.print("Invalid Path");
        }

    }
}
