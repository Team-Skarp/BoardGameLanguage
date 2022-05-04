package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.SymbolTable;
import SymbolTable.Symbol;
import SymbolTable.Block;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;
import SymbolTable.types.StringType;

import java.util.List;


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
        String str = "#include <stdio.h>\n#include<stdbool.h>\n#include<math.h>\n#include <string.h>\n#include <stdlib.h>\n" +
                "\n" +
                "int main(int argc, char *argv[])";
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
        String str = "";
        List<Block> childBlocks = ST.getActiveBlock().getChildren();

        if (childBlocks.size() > 0) {
            for (Block block : childBlocks) {

                ST.dive();

                str = "{\n";
                for (ASTNode c: n.children){
                    str += (String) c.accept(this);
                }
                str += "}";

            }
        } else {
            str = "{\n";
            for (ASTNode c: n.children){
                str += (String) c.accept(this);
            }
            str += "}";
        }

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
    public String visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public String visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public String visit(Declaration n) {
        lo.g(n);
        return null;
    }

    @Override
    public String visit(ActionDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(DesignDeclarationNode n) {
        return null;
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
        String str = n.type() +" "+n.name;
        if(n.value != null){
            str += " = "+n.value.accept(this);
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
        String str = "bool "+n.name;
        if(n.value != null){
            str += " = "+n.value.accept(this);
        }
        str += EOL;
        return str;
    }

    @Override
    public String visit(StringDeclarationNode n) {

        String str = "char* "+n.name+EOL;
        if(n.value != null){
            String end = (String) n.value.accept(this);

            str += n.name+" = (char *) malloc("+end.length()+")"+EOL;
            str += "strcpy("+n.name+","+end+")"+EOL;
        }else{
            str += n.name+" = (char *) malloc(2)"+EOL;
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
        //TODO: await jakob on functions
        String str = "";
        /*str +="for(int i = 0; i < sizeof("+n.mainId+")/sizeof("+n.mainId+"[0]); i++)";
        str +=n.foreachBlock.accept(this);*/
        return str;
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
    public String visit(ActionCallNode n) {
        return null;
    }

    @Override
    public String visit(ReturnNode n) {
        return null;
    }
}
