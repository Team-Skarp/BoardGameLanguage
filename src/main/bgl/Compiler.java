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
import java.util.List;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@SuppressWarnings("rawtypes")
public class Compiler {

    // Code for StreamGobbler Taken from: https://www.baeldung.com/run-shell-command-in-java
    private record StreamGobbler(
            InputStream inputStream,
            Consumer<String> consumer
    ) implements Runnable {

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

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

    private static void writeSTDLIB(ASTvisitor generator) throws IOException {
        try (FileWriter fw = new FileWriter(
                "./src/main/bgl/BglFiles/Generated/bgllib.h",
                false
        )) {
            fw.write(STDLIBC.imports);
            fw.write(STDLIBC.defines);

            if (generator instanceof CCodeGenerator ccg) {
                fw.write(ccg.definitions);
            }

            System.out.println("Compiled successfully");
        } catch (IOException ex) {
            throw new IOException("Could not write to file");
        }
    }

    private static void writeBinary(String outputFileName) throws IOException, InterruptedException {
        // Locate C files.
        File stdlibFile = new File("./src/main/bgl/BglFiles/Generated/bgllib.h");
        File userFile = new File("./src/main/bgl/BglFiles/Generated/%s".formatted(outputFileName));

        if (stdlibFile.exists() && userFile.exists()) {
            String inputFilePath = "./src/main/bgl/BglFiles/Generated/%s".formatted("test.c");
            String outputFilePath = "./src/main/bgl/BglFiles/Generated/%s".formatted("test.exe");

            // CMD command to compile with GNU compiler
            ProcessBuilder builder = new ProcessBuilder();

            // "/c" - creates a new shell, execute the provided command, and exit from the shell automatically
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
                builder.command("cmd.exe", "/c", "gcc", "src/main/bgl/BglFiles/Generated/test.c");
            } else {
                builder.command("cmd", "gcc", inputFilePath, "-o", outputFilePath);
            }

//            if (System.getProperty("os.name").toLowerCase().startsWith("windows")){
//                builder.command("cmd.exe", "/c", "dir");
//            } else {
//                builder.command("sh", "-c", "ls");
//            }

            Process process = builder.start();
            StreamGobbler gobbler = new StreamGobbler(process.getInputStream(), System.out::println);
            Executors.newSingleThreadExecutor().submit(gobbler);

            int exitCode = process.waitFor();
            assert exitCode == 0;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

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
        String outputPath = "./src/main/bgl/BglFiles/Generated/%s".formatted(outputFileName);

        try (FileWriter fw = new FileWriter(outputPath, false)) {
            fw.write(code);
        } catch (IOException ex) {
            throw new IOException("Could not write to file");
        }

        // if output file format is C and -full flag is present compile with GCC
        if (arguments.contains("-full") && arguments.contains("-c")) {
            writeBinary(outputFileName);
        }

    }
}
