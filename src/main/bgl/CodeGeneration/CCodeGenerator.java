package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.SymbolTable;
import SymbolTable.Symbol;
import SymbolTable.types.*;

/**
 * Class for generating C code.
 * "gcc out.c -o out && ./out"
 */
public class CCodeGenerator implements ASTvisitor<String> {

    private SymbolTable     ST;
    private int             indent = 0;
    private final String    TAB = "\t";
    Logger lo =             new Logger();
    private final String EOL = ";\n";

    public CCodeGenerator(SymbolTable ST) {
        this.ST = ST;
    }

    @Override
    public String visit(GameNode n) {
        return (
                """
                #include <stdio.h>
                #include<stdbool.h>
                #include<math.h>
                #include <string.h>
                #include <stdlib.h>
                
                #define foreach(item, array)                         \\
                    for (int keep = 1,                               \\
                             count = 0,                              \\
                             size = sizeof(array) / sizeof *(array); \\
                         keep && count != size;                      \\
                         keep = !keep, count++)                      \\
                        for (item = (array) + count; keep; keep = !keep)

                int main(int argc, char *argv[]) %s
                """.formatted(
                        n.setup.accept(this)
                )
        );
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
        String str = " ( "+n.left.accept(this)+" + "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(MinusNode n) {
        String str = " ( "+n.left.accept(this)+" - "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(UnaryMinusNode n) {
        String str = " ( -( "+n.operand.accept(this)+" ) ) ";
        return str;
    }

    @Override
    public String visit(MultNode n) {
        String str = " ( "+n.left.accept(this)+" * "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(DivNode n) {
        String str = " ( "+n.left.accept(this)+" / "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(ModNode n) {
        String str = " ( "+n.left.accept(this)+" % "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(PowNode n) {
        String str = " ( (int)pow("+n.left.accept(this)+", "+n.right.accept(this)+") ) ";
        return str;
    }

    @Override
    public String visit(IdNode n) {
        String str = ""+n.name;
        return str;
    }

    @Override
    public String visit(IntNode n) {
        String str = n.value+"";
        return str;
    }

    @Override
    public String visit(BooleanNode n) {
        String str = ""+n.value;
        return str;
    }

    @Override
    public String visit(StringNode n) {
        String str = "\""+n.value+"\"";
        return str;
    }

    @Override
    public String visit(BooleanExpression n) {
        return null;
    }

    @Override
    public String visit(EqualNode n) {
        String str = " ( "+n.left.accept(this)+"=="+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(NotEqualNode n) {
        String str = " ( "+n.left.accept(this)+" != "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(LessThanNode n) {
        String str = " ( "+n.left.accept(this)+" < "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(GreaterThanNode n) {
        String str = " ( "+n.left.accept(this)+" > "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        String str = " ( "+n.left.accept(this)+" >= "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        String str = " ( "+n.left.accept(this)+" <= "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(NegationNode n) {
        String str = " ( !( "+n.child.accept(this)+" ) )";
        return str;
    }

    @Override
    public String visit(OrNode n) {
        String str = " ( "+n.left.accept(this)+" || "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(AndNode n) {
        String str = " ( "+n.left.accept(this)+" && "+n.right.accept(this)+" ) ";
        return str;
    }

    @Override
    public String visit(BlockNode n) {
        String str;

        //Go down into the scope of this block
        ST.dive();

        //Generate C code from withing this block
        str = "{\n";
        indent++;
        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }
        indent--;
        str += "}";

        //When finished, climb back to parrent scope
        ST.climb();

        return str;
    }

    @Override
    /**
     * Block that can have passed down variables. Behaves like a Block
     */
    public String visit(ParameterBlock n) {
        String str;

        ST.dive();

        str = "{\n";
        indent++;
        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }
        indent--;
        str += "}";

        ST.climb();

        return str;
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
        return null;
    }

    @Override
    public String visit(IntegerAssignmentNode n) {
        return null;
    }

    @Override
    public String visit(BooleanAssignmentNode n) {
        return null;
    }

    @Override
    public String visit(DesignDefinitionNode n) {

        String designBody = "";
        indent++;
        for (Declaration field : n.fields) {
            designBody += TAB.repeat(indent) + field.accept(this);
        }
        indent--;
        
        return (
                """
                struct %s {
                %s};
                """.formatted(
                        n.typeDefinition.name,
                        designBody,
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

        String formalParams = "";
        for (Declaration param : n.formalParameters) {
            formalParams += TAB.repeat(indent) + param.accept(this);
        }

        return (
                """
                %s (*%s)(%s);
                """
                ).formatted(
                toCString(n.returnType),
                n.name,
                formalParams
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

        String braces = "[]";
        TypeDenoter finalType = n.elementType;

        //Algorithm to find the final type of a list
        while (finalType instanceof ListType) {
            ListType temp = (ListType) finalType;
            finalType = temp.elementType;
            braces += "[]";
        }

        return (
                """
                %s %s%s;
                """.formatted(
                        toCString(finalType),
                        n.name,
                        braces
                )
                );
    }

    /**
     * Turns a type denoter into usable C string;
     * @param type
     * @return C string of the type
     */
    private String toCString(TypeDenoter type) {
        String string = "";
        if (type instanceof IntType) {
            string = "int";
        }
        else if (type instanceof StringType) {
            string = "char[]";
        }
        else if (type instanceof BoolType) {
            string = "bool";
        }
        else if (type instanceof DesignRef temp) {
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
        String str = "";
        for(ASTNode decl: n.declarations){
            str+=decl.accept(this);
        }
        return str;
    }

    @Override
    public String visit(IntegerDeclarationNode n) {
        if (n.value != null) {
            return """
                   %s %s = %s;
                   """.formatted(
                    toCString(n.type()),
                    n.name,
                    n.value.accept(this)
            );
        }
        else {
            return """
                   %s %s;
                   """.formatted(
                    toCString(n.type()),
                    n.name
                    );
        }
    }

    @Override
    public String visit(IntegerAssignDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(BooleanDeclarationNode n) {
        String str = "bool "+n.name;
        if(n.value != null){
            str += " = "+n.value.accept(this);
        }
        str += EOL;
        return str;
    }

    @Override
    public String visit(StringDeclarationNode n) {

        //TODO: when assignment needs to be done for strings. use this:
        //n.name+" = (char *) realloc("+n.name+","+end.length()+")"+EOL;
        //"strcpy("+n.name+", "+end+")"+EOL;
        if (n.value != null) {
            String val = (String) n.value.accept(this);
            return """
                   %s %s = %s malloc(%d);
                   strcpy(%s, %s);
                   """.formatted(
                    toCString(n.type()),
                    n.name,
                    toCString(n.type()),
                    val.length(),
                    n.name,
                    n.value.accept(this)
            );
        }
        else {
            return """
                   %s %s = %s malloc(%d);
                   """.formatted(
                    toCString(n.type()),
                    n.name,
                    toCString(n.type()),
                    2                       //Allocate 2 bytes by default on string declarations
            );
        }

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
        String str = "if("+n.predicate.accept(this)+")"+n.ifBlock.accept(this);

        if(n.elseifBlocks != null){
            for(ASTNode elif : n.elseifBlocks){
                str += (String) elif.accept(this);
            }
        }
        if(n.elseBlock != null){
            str+="else"+n.elseBlock.accept(this);
        }
        return str;
    }

    @Override
    public String visit(ElifConditionalNode n) {
        String str = "else if("+n.predicate.accept(this)+")"+n.ifBlock.accept(this);

        return str;
    }

    @Override
    public String visit(ElseNode n) {
        lo.g("why are you in this node?");
        return null;
    }

    @Override
    public String visit(PredicateNode n) {
        String str = n.value.accept(this)+"";
        return str;
    }

    @Override
    public String visit(WhileNode n) {
        String str = "while("+n.predicate.accept(this)+")"+n.whileBlock.accept(this);
        return str;
    }

    @Override
    public String visit(ForeachNode n) {

        Symbol iteratorSymbol = ST.retrieveSymbol(n.iterator.name);

        /*str +="for(int i = 0; i < sizeof("+n.mainId+")/sizeof("+n.mainId+"[0]); i++)";
        str +=n.foreachBlock.accept(this);*/

        return """
               foreach (%s *%s, %s) %s
               """.formatted(
                        iteratorSymbol.type instanceof StringType ? "char" : toCString(iteratorSymbol.type),
                        n.iterator.name,
                        n.iterable.name,
                        n.body.accept(this)
                    );
    }

    @Override
    public String visit(PrintNode n) {
        String str = "printf(\"";
        String endPart = "";
        for(ASTNode p : n.prints){
            if(p.getClass() == StringNode.class){
                //string literals
                str +="%s";
                endPart += ", \""+((StringNode) p).value+"\"";
            }else if(p.getClass() == IdNode.class){
                Symbol symbol = ST.retrieveSymbol(((IdNode) p).name);
                if(symbol.type instanceof IntType){
                    str +="%d";
                    endPart += (","+((IdNode) p).name);

                }else if(symbol.type instanceof StringType){
                    str +="%s";
                    endPart += (","+((IdNode) p).name);

                }else if(symbol.type instanceof BoolType){
                    str +="%s";
                    endPart += ","+p.accept(this)+" ? \"true\" : \"false\"";

                }
                else {
                    System.out.println("Incompatible type for print");
                }
                //variables
                //TODO: implement symbol table, to recognize what type the var is, and change outcome based on that
                //endPart += (","+((IdNode) p).name);
            }else if(p instanceof ArithmeticExpression ){
                //arithmetic
                str +="%d";
                endPart += ","+p.accept(this);
            }else if(p instanceof BooleanExpression){
                //boolean
                str +="%s";
                endPart += ","+p.accept(this)+" ? \"true\" : \"false\"";
            }

        };
        str += "\\n\""+endPart+")"+EOL;

        //char text[13] = " cars in the ";
        //printf("%d%s%s\n",2*2,text, "garage");
        return str;
    }

    @Override
    public String visit(InputNode n) {
        return null;
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
