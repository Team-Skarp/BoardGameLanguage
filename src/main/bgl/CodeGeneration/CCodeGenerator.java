package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import ASTvisitors.PrettyPrinter;
import Logging.Logger;
import SymbolTable.SymbolTable;
import SymbolTable.Symbol;
import SymbolTable.Block;
import SymbolTable.types.*;

import java.util.List;


/**
 * Class for generating C code.
 * "gcc out.c -o out && ./out"
 */
public class CCodeGenerator implements ASTvisitor<String> {

    private SymbolTable ST;
    private int indent = 0;
    private final String TAB = "\t";
    Logger lo = new Logger();
    private final String EOL = ";\n";

    public CCodeGenerator(SymbolTable ST) {
        this.ST = ST;
    }

    @Override
    public String visit(GameNode n) {
        String str = """
                #include <stdio.h>
                #include <stdbool.h>
                #include <math.h>
                #include <string.h>
                #include <stdlib.h>
                
                #define foreach(item, array)                         \\
                    for (int keep = 1,                               \\
                             count = 0,                              \\
                             size = sizeof(array) / sizeof *(array); \\
                         keep && count != size;                      \\
                         keep = !keep, count++)                      \\
                        for (item = (array) + count; keep; keep = !keep)

                int main(int argc, char *argv[])""";
        str += (String) n.setup.accept(this);
        return str;
    }

    @Override
    public String visit(Expression n) {
        return null;
    }


    @Override
    public String visit(ArithmeticExpression n) {
        lo.g(n);
        return null;
    }

    @Override
    public String visit(PlusNode n) {
        return "( " + n.left.accept(this) + " + " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(MinusNode n) {
        return "( " + n.left.accept(this) + " - " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(UnaryMinusNode n) {
        return "( -( " + n.operand.accept(this) + " ) )";
    }

    @Override
    public String visit(MultNode n) {
        return "( " + n.left.accept(this) + " * " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(DivNode n) {
        return "( " + n.left.accept(this) + " / " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(ModNode n) {
        return "( " + n.left.accept(this) + " % " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(PowNode n) {
        return "( (int)pow(" + n.left.accept(this) + ", " + n.right.accept(this) + ") )";
    }

    @Override
    public String visit(IdNode n) {
        return "" + n.name;
    }

    @Override
    public String visit(IntNode n) {
        return n.value + "";
    }

    @Override
    public String visit(BooleanNode n) {
        return "" + n.value;
    }

    @Override
    public String visit(StringNode n) {
        return "\"" + n.value + "\"";
    }

    @Override
    public String visit(BooleanExpression n) {
        return (String) n.accept(this);
    }

    @Override
    public String visit(EqualNode n) {
        return "( " + n.left.accept(this) + "==" + n.right.accept(this) + " )";
    }

    @Override
    public String visit(NotEqualNode n) {
        return "( " + n.left.accept(this) + " != " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(LessThanNode n) {
        return "( " + n.left.accept(this) + " < " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(GreaterThanNode n) {
        return "( " + n.left.accept(this) + " > " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        return "( " + n.left.accept(this) + " >= " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        return "( " + n.left.accept(this) + " <= " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(NegationNode n) {
        return "( !( " + n.child.accept(this) + " ) )";
    }

    @Override
    public String visit(OrNode n) {
        return "( " + n.left.accept(this) + " || " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(AndNode n) {
        return "( " + n.left.accept(this) + " && " + n.right.accept(this) + " )";
    }

    @Override
    public String visit(BlockNode n) {
        StringBuilder str = new StringBuilder();
        List<Block> childBlocks = ST.getActiveBlock().getChildren();

        if (childBlocks.size() > 0) {
            for (Block block : childBlocks) {

                ST.dive();

                str = new StringBuilder("{\n");
                for (ASTNode c : n.children) {
                    str.append((String) c.accept(this));
                }
                str.append("}");

            }
        } else {
            str = new StringBuilder("{\n");
            for (ASTNode c : n.children) {
                str.append((String) c.accept(this));
            }
            str.append("}");
        }

        ST.climb();

        return str.toString();
    }

    @Override
    public String visit(ActionBodyNode n) {
        return null;
    }

    @Override
    public String visit(Assignment n) {
        System.out.println("SSSSSSSSSSSSSSSSSSs");
        return null;
    }

    @Override
    public String visit(StringAssignmentNode n) {
        return "%s = %s%s".formatted(n.varName, n.literal, EOL);
    }

    @Override
    public String visit(IntegerAssignmentNode n) {
        return "%s = %s%s".formatted(n.id.name, n.aexpr.accept(this), EOL);
    }

    @Override
    public String visit(BooleanAssignmentNode n) {
        return "%s = %s%s".formatted(n.varName, n.bexpr.accept(this), EOL);
        //return String.format(n.varName, = ",n.bexpr.accept(this));
    }

    @Override
    public String visit(DesignDefinitionNode n) {

        StringBuilder designBody = new StringBuilder();
        for (Declaration field : n.fields) {
            designBody.append(TAB).append(field.accept(this));
        }

        return (
                """
                        struct %s {
                        %s};
                        """.formatted(
                        n.typeDefinition.name,
                        designBody.toString(),
                        n.typeDefinition
                ));

    }

    @Override
    public String visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public String visit(Declaration n) {
        lo.g(n);
        return (String) n.accept(this);
    }

    @Override
    public String visit(ActionDeclarationNode n) {

        StringBuilder formalParams = new StringBuilder();
        for (Declaration param : n.formalParameters) {
            formalParams.append(param.accept(this));
        }

        return (
                """
                        %s (*%s)(%s);
                        """
        ).formatted(
                toCString(n.returnType),
                n.name,
                formalParams.toString()
        );
    }

    @Override
    public String visit(DesignDeclarationNode n) {

        return (
                """
                        struct %s *%s;
                        """
                        .formatted(
                                n.ref.name,
                                n.name
                        ));
    }

    @Override
    public String visit(ListDeclarationNode n) {

        StringBuilder braces = new StringBuilder("[]");
        TypeDenoter finalType = n.elementType;

        //Algorithm to find the final type of a list
        while (finalType instanceof ListType) {
            ListType temp = (ListType) finalType;
            finalType = temp.elementType;
            braces.append("[]");
        }

        return (
                """
                        %s %s%s;
                        """.formatted(
                        toCString(finalType),
                        n.name,
                        braces.toString()
                )
        );
    }

    /**
     * Turns a type denoter into usable C string;
     *
     * @param type
     * @return C string of the type
     */
    private String toCString(TypeDenoter type) {
        String string = "";
        if (type instanceof IntType) {
            string = "int";
        } else if (type instanceof StringType) {
            string = "char[]";
        } else if (type instanceof BoolType) {
            string = "bool";
        } else if (type instanceof DesignRef temp) {
            string = "struct %s".formatted(temp.name);
        }
        else if (type instanceof VoidType) {
            string = "void";
        }
        else {
            throw new RuntimeException("Invalid return type '%s'".formatted(type));
        }

        return string;
    }

    @Override
    public String visit(SequentialDeclaration n) {
        StringBuilder str = new StringBuilder();
        for (ASTNode decl : n.declarations) {
            str.append(decl.accept(this));
        }
        return str.toString();
    }

    @Override
    public String visit(IntegerDeclarationNode n) {
        String str = n.type() + " " + n.name;
        if (n.value != null) {
            str += " = " + n.value.accept(this);
        }
        str += EOL;
        return str;
    }

    @Override
    public String visit(IntegerAssignDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(BooleanDeclarationNode n) {
        String str = "bool " + n.name;
        if (n.value != null) {
            str += " = " + n.value.accept(this);
        }
        str += EOL;
        return str;
    }

    @Override
    public String visit(StringDeclarationNode n) {

        String str = "char* " + n.name + EOL;
        if (n.value != null) {
            String end = (String) n.value.accept(this);

            str += n.name + " = (char *) malloc(" + end.length() + ")" + EOL;
            str += "strcpy(" + n.name + "," + end + ")" + EOL;
        } else {
            str += n.name + " = (char *) malloc(2)" + EOL;
        }
        return str;

        //TODO: when assignment needs to be done for strings. use this:
        //n.name+" = (char *) realloc("+n.name+","+end.length()+")"+EOL;
        //"strcpy("+n.name+", "+end+")"+EOL;
    }


    @Override
    public String visit(PathDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(GridDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(GridTypedDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(ConditionalNode n) {
        StringBuilder str = new StringBuilder("if(" + n.predicate.accept(this) + ")" + n.ifBlock.accept(this));

        if (n.elseifBlocks != null) {
            for (ASTNode elif : n.elseifBlocks) {
                str.append((String) elif.accept(this));
            }
        }
        if (n.elseBlock != null) {
            str.append("else").append(n.elseBlock.accept(this));
        }
        return str.toString();
    }

    @Override
    public String visit(ElifConditionalNode n) {

        return "else if(" + n.predicate.accept(this) + ")" + n.ifBlock.accept(this);
    }

    @Override
    public String visit(ElseNode n) {
        lo.g("why are you in this node?");
        return null;
    }

    @Override
    public String visit(PredicateNode n) {
        return n.value.accept(this) + "";
    }

    @Override
    public String visit(WhileNode n) {
        return "while(" + n.predicate.accept(this) + ")" + n.whileBlock.accept(this);
    }

    @Override
    public String visit(ForeachNode n) {
        Symbol iterableSymbol = ST.retrieveSymbol(n.iterable.name);
        Symbol iteratorSymbol = ST.retrieveSymbol(n.iterator.name);

        /*str +="for(int i = 0; i < sizeof("+n.mainId+")/sizeof("+n.mainId+"[0]); i++)";
        str +=n.foreachBlock.accept(this);*/

        return """
                foreach (%s *%s, %s) {
                    %s
                }
                """.formatted(
                        iteratorSymbol.type instanceof StringType ? "char" : toCString(iteratorSymbol.type),
                        n.iterator.name,
                        n.iterable.name,
                        n.body.accept(this)
                    );
    }

    @Override
    public String visit(PrintNode n) {
        StringBuilder str = new StringBuilder("printf(\"");
        StringBuilder endPart = new StringBuilder();
        for (ASTNode p : n.prints) {
            if (p.getClass() == StringNode.class) {
                //string literals
                str.append("%s");
                endPart.append(", \"").append(((StringNode) p).value).append("\"");
            } else if (p.getClass() == IdNode.class) {
                Symbol symbol = ST.retrieveSymbol(((IdNode) p).name);
                if (symbol.type instanceof IntType) {
                    str.append("%d");
                    endPart.append(",").append(((IdNode) p).name);

                } else if (symbol.type instanceof StringType) {
                    str.append("%s");
                    endPart.append(",").append(((IdNode) p).name);

                } else if (symbol.type instanceof BoolType) {
                    str.append("%s");
                    endPart.append(",").append(p.accept(this)).append(" ? \"true\" : \"false\"");

                } else {
                    System.out.println("Incompatible type for print");
                }
                //variables
                //TODO: implement symbol table, to recognize what type the var is, and change outcome based on that
                endPart.append(",").append(((IdNode) p).name);
            } else if (p instanceof ArithmeticExpression) {
                //arithmetic
                str.append("%d");
                endPart.append(",").append(p.accept(this));
            } else if (p instanceof BooleanExpression) {
                //boolean
                str.append("%s");
                endPart.append(",").append(p.accept(this)).append(" ? \"true\" : \"false\"");
            }

        }
        ;
        str.append("\\n\"").append(endPart).append(")").append(EOL);

        //char text[13] = " cars in the ";
        //printf("%d%s%s\n",2*2,text, "garage");
        return str.toString();
    }

    @Override
    public String visit(InputNode n) {
        String str = "scanf(\"";
        IdNode variableName = n.inputVariableName;
        if (variableName.getClass() == IdNode.class) {
            Symbol symbol = ST.retrieveSymbol(variableName.name);
            if (symbol.type instanceof IntType) {
                str += ("%d, &" + variableName.name);

            } else if (symbol.type instanceof StringType) {
                str += ("%s, &" + variableName.name);

            } else if (symbol.type instanceof BoolType) {
                str += ("%s, &" + variableName.name);

            } else {
                System.out.println("Incompatible type for input");
            }

            str += ")" + EOL;
        }
        return str;
    }

    @Override
    public String visit(ActionCallNode n) {
        return null;
    }

    @Override
    public String visit(ReturnNode n) {
        return null;
    }
}
