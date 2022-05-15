package Demos;

import ASTnodes.ASTNode;
import CodeGeneration.CCodeGenerator;
import SymbolTable.SymbolHarvester;
import SymbolTable.SymbolTable;
import antlr.BoardLexer;
import antlr.BoardParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import ASTvisitors.ASTbuilder;

import java.io.FileWriter;
import java.io.IOException;

public class CGenerationDemo {
    public static void main(String[] args) {

        // Setup
        CharStream input;
        BoardLexer lexer;
        CommonTokenStream tokens;
        BoardParser parser;

        /*
        * use this string starting from gamestart, before pushing any changes.
        * no errors must occur when parsing this string.
        */
        String bglCodeExample =
                """
                SETUP {
                   int a = 2;
                   design Animal {
                        action eat();
                   }
                   
                   design Dog {
                        Animal parent;
                        action bark();
                        action woof();
                        
                        list:int theIntList1;
                   }
                   
                   Animal ape;
                   Dog poodle;
                   Dog pug;
                   
                   list:list:list:Dog poodleList = [ [], [[poodle, poodle], []], [[poodle, poodle]]  ];
                   
                   list:Dog pugList = [[[]]];
		   
                   list:int theIntList2 = [10, 20, 30];
                   
                   list:bool theBoolList = [true, false, true];
                   
                   list:list:int theMatrix = [[1,2,3],[4,5,6]];
                   
                   print("list decls working, but we must go deeper");
                   
                   list:list:list:int theCubrix = [ [ [1] ], [ [2] ], [ [3] ] ];
                   
                   print("but it's still not enough!");
                   
                   list:list:list:list:int theQuadrix = [
                                                            [
                                                                [
                                                                    [1,2],[3,4]
                                                                ],
                                                                [
                                                                    [5,6],[7,8]
                                                                ]
                                                            ],
                                                            [
                                                                [
                                                                    [9,10],[11,12]
                                                                ],
                                                                [
                                                                    [13,14],[15,16]
                                                                ]
                                                            ]
                                                        ];
                   
                   Dog bulldog;
                   
                   bulldog.parent.eat();
                   exit;
                }
                RULES {
                    action eat() {
                        print("eat!");
                    }
                    action bark() {
                        print("bark!");
                    }
                    action woof() {
                        print("woof!");
                      
                    }
                    exit;
                }
                GAMELOOP {
                    
                    
                    input(a);
                    print(a);
                    exit;
                    return 1;
                }
                """;


        // Parse Input
        input   = CharStreams.fromString(bglCodeExample);
        lexer   = new BoardLexer(input);
        tokens  = new CommonTokenStream(lexer);
        parser  = new BoardParser(tokens);

        // Created CST from Parser
        BoardParser.GameContext cst = parser.game();
        ASTNode ast = new ASTbuilder().visitGame(cst);

        // Symmbol harvester
        SymbolHarvester SH = new SymbolHarvester();
        SymbolTable ST = (SymbolTable) ast.accept(SH);

        // C - code generation
        CCodeGenerator generator = new CCodeGenerator(ST, SH.TENV);

        // Pass generator to ast
        String code = (String) ast.accept(generator);
        System.out.println(code);
        try {
            FileWriter fw = new FileWriter("./src/main/bgl/CodeGeneration/GeneratedFiles/out.c",false);
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
