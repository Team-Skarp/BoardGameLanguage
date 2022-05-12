package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.SymbolTable;
import SymbolTable.TypeEnvironment;
import SymbolTable.Symbol;
import SymbolTable.types.*;

import static STDLIB.STDLIBC.*;         //C imports and defines

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class for generating C code.
 * "gcc out.c -o out && ./out"
 */
public class CCodeGenerator implements ASTvisitor<String> {

    private final SymbolTable   ST;
    private final TypeEnvironment TENV;

    Logger                      lo = new Logger();
    HashMap<String,String>      foreachDict = new HashMap<>();

    public String               header = "";
    public String               prototypes = "";
    public String               definitions = "";

    private int                 indent = 0;
    private final String        TAB = "\t";
    private final String        EOL = ";\n";

    public CCodeGenerator(SymbolTable ST, TypeEnvironment TENV) {
        this.ST = ST;
        this.TENV = TENV;
    }

    @Override
    public String visit(GameNode n) {
        String userCode;
        header += """
               %s
               %s
               """.formatted(imports, defines);

        //Everything in rules block gets put on top level in C code
        n.rules.accept(this);

        userCode =
                """
                int main(int argc, char *argv[]) {
                    %s
                    while(true) {
                       %s
                    }
                }
                """.formatted(
                    n.setup.accept(this),
                    n.gameloop.accept(this)
                );

        return (header + prototypes + definitions + userCode);
    }

    @Override
    public String visit(Expression n) {
        return (String) n.accept(this);
    }


    @Override
    public String visit(ArithmeticExpression n) {
        return (String) n.accept(this);
    }

    @Override
    public String visit(PlusNode n) {
        return " ( "+n.left.accept(this)+" + "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(MinusNode n) {
        return " ( "+n.left.accept(this)+" - "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(UnaryMinusNode n) {
        lo.g(n.operand.accept(this).toString()+" unary minus");
        return " ( -( "+n.operand.accept(this)+" ) ) ";
    }

    @Override
    public String visit(MultNode n) {
        return " ( "+n.left.accept(this)+" * "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(DivNode n) {
        return " ( "+n.left.accept(this)+" / "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(ModNode n) {
        return " ( "+n.left.accept(this)+" % "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(PowNode n) {
        return " ( (int)pow("+n.left.accept(this)+", "+n.right.accept(this)+") ) ";
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
        return " ( "+n.left.accept(this)+"=="+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(NotEqualNode n) {
        return " ( "+n.left.accept(this)+" != "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(LessThanNode n) {
        return " ( "+n.left.accept(this)+" < "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(GreaterThanNode n) {
        return " ( "+n.left.accept(this)+" > "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        return " ( "+n.left.accept(this)+" >= "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        return " ( "+n.left.accept(this)+" <= "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(NegationNode n) {
        return " ( !( "+n.child.accept(this)+" ) )";
    }

    @Override
    public String visit(OrNode n) {
        return " ( "+n.left.accept(this)+" || "+n.right.accept(this)+" ) ";
    }

    @Override
    public String visit(AndNode n) {
        return " ( "+n.left.accept(this)+" && "+n.right.accept(this)+" ) ";
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
    public String visit(NonScopeBlockNode n) {
        String str = "";

        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }

        return str;
    }


    @Override
    public String visit(Assignment n) {
        return null;
    }

    @Override
    public String visit(StringAssignmentNode n) {
        String str = "";
        str += n.varName+" = (char *) realloc("+n.varName+","+n.literal.length()+")"+EOL;
        str += "strcpy("+n.varName+", "+n.literal+")"+EOL;
        return str;
    }

    @Override
    public String visit(IntegerAssignmentNode n) {
        return n.id.name+" = "+n.aexpr.accept(this)+EOL;
    }

    @Override
    public String visit(BooleanAssignmentNode n) {
        return n.varName+" = "+n.bexpr.accept(this)+EOL;
    }

    @Override
    public String visit(DotAssignmentNode n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n.fieldAccessNode.fields.size() - 1; i++) {
            str.append(n.fieldAccessNode.fields.get(i));
        }
        str.deleteCharAt(str.length() - 1);
        str.append("->").append(n.fieldAccessNode.fields.get(n.fieldAccessNode.fields.size() - 1)).
        append(" = ").append(n.expr.accept(this)).append(EOL);
        /*str
                n.fieldAccessNode.accept(this)+" = "+n.expr.accept(this);
        str = str.replace(";","").replace("\n","") + EOL;*/
        return str.toString();
    }

    @Override
    /**
     * Should only append to top level code
     */
    public String visit(DesignDefinitionNode n) {
        String designBody = "";
        indent++;
        for (Declaration field : n.fields) {

            designBody += TAB.repeat(indent) + field.accept(this);
        }
        indent--;

        if (n.parentType != null) {
            definitions +=  """
                    struct %s {
                    struct %s parent;
                    %s};
                    """.formatted(
                    n.typeDefinition.name,
                    n.parentType.name,
                    designBody,
                    n.typeDefinition
            );
        } else {
            definitions +=  """
                    struct %s {
                    %s};
                    """.formatted(
                    n.typeDefinition.name,
                    designBody,
                    n.typeDefinition
                    );
        }

        return "";
    }

    @Override
    public String visit(ActionDefinitionNode n) {

        //Actions definitions are put on the top of the C code. A prototype for the definition is also added
        definitions += """
               %s %s(%s) %s
               """.formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters),
                n.body.accept(this)
        );

        prototypes += """
               %s %s(%s);
               """.formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters)
        );

        return "";
    }

    @Override
    public String visit(Declaration n) {
        return (String) n.accept(this);
    }

    @Override
    /**
     * Action declarations writes a prototype at the top of the file
     */
    public String visit(ActionDeclarationNode n) {

        String actionDcl = "";

        actionDcl +=
                """
                %s (*%s)(%s);
                """
                .formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters)
        );

        //Add the action declaration as a prototype
        prototypes += toCPrototype(n);

        return actionDcl;
    }

    /**
     * Converts a list of declarations to parameters
     *
     * Ex. int a; str b; list:int c -> "int a, char* b, int* c"
     */
    private String toCParams(List<Declaration> formalParams) {
        //Create string for formal parameters
        String params = "";
        for (Declaration param : formalParams) {
            params += param.accept(this) + ",";
        }

        //Remove trailing comma and semicolons
        if (params.length() > 0) {
            params = params.substring(0, params.length() - 1);
            params = params.replaceAll(";", "");
        }

        return params;
    }

    private String toCPrototype(ActionDeclarationNode n) {

        return """
               %s %s(%s);
               """.formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters)
        );
    }

    @Override
    public String visit(DesignDeclarationNode n) {

        DesignType thisType = TENV.receiveType(n.dName);

        if (n.value != null) {

            // Cast parent param to struct of parent type
            if (n.value.get(0).contains("{") && n.value.get(0).contains("}")) {
                n.value.set(0,"(struct %s)%s".formatted(thisType.parent, n.value.get(0)));
            }

            // Joined string for init
            String collectedString = String.join(", ", n.value);

            return (
                    """
                    struct %s %s = {%s};
                    """.formatted(n.dName, n.name, collectedString)
            );
        } else {
            return (
                    """
                    struct %s %s;
                    """.formatted(n.dName, n.name)
            );
        }
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
                        toCType(finalType),
                        n.name,
                        braces
                )
                );
    }

    /**
     * Maps a type denoter to a C type;
     * @param type
     * @return C string of the type
     */
    public static String toCType(TypeDenoter type) {
        String string;
        if (type instanceof IntType) {
            string = "int";
        }
        else if (type instanceof StringType) {
            string = "char*";
        }
        else if (type instanceof BoolType) {
            string = "bool";
        }
        else if (type instanceof DesignRef design) {
            string = "struct %s".formatted(design.name);
        }
        else if (type instanceof VoidType) {
            string = "void";
        }

        else if (type instanceof ListType list) {

            TypeDenoter finalType = list.elementType;

            //Find the final type of the list
            int numOfPointers = 1;
            while (finalType instanceof ListType temp) {
                finalType = temp.elementType;
                numOfPointers++;
            }

            string = toCType(finalType) + "*".repeat(numOfPointers);
        }
        else {
            throw new RuntimeException("No mapping for type '%s' to a C type was found".formatted(type));
        }

        return string;
    }

    @Override
    public String visit(SequentialDeclaration n) {
        String str = "";
        for(ASTNode decl: n.declarations){
            str+= decl.accept(this);
        }
        return str;
    }

    @Override
    public String visit(IntegerDeclarationNode n) {
        //TODO Fix indent somewhere between this and sequential decl. Also fix sequential decl.
        if (n.value != null) {
            return """
                   %s %s = %s;
                   """.formatted(
                    toCType(n.type()),
                    n.name,
                    n.value.accept(this)
            );
        } else {
            return """
                   %s %s;
                   """.formatted(
                    toCType(n.type()),
                    n.name
                    );
        }
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
                   %s %s = %s;
                   """.formatted(
                    toCType(n.type()),
                    n.name,
                    n.value.accept(this)
            );
        }
        else {
            return """
                   %s %s;
                   """.formatted(
                    toCType(n.type()),
                    n.name,
                    toCType(n.type()),
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

        if(n.elseifBlocks != null ){
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
        return "else if("+n.predicate.accept(this)+")"+n.ifBlock.accept(this);
    }

    @Override
    public String visit(ElseNode n) {
        n.elseBlock.accept(this);
        return "";
    }

    @Override
    public String visit(PredicateNode n) {
        String str = n.value.accept(this)+"";
        return str;
    }

    @Override
    public String visit(WhileNode n) {
        lo.g(n.predicate.accept(this));
        String str = "while("+n.predicate.accept(this)+")"+n.whileBlock.accept(this);
        lo.g("whlenode");
        return str;
    }

    @Override
    public String visit(ForeachNode n) {

        Symbol iteratorSymbol = ST.retrieveSymbol(n.iterator.name);
        foreachDict.put(n.iterator.name,"c");
        return """
               foreach (%s *%s, %s) %s
               """.formatted(
                        iteratorSymbol.type instanceof StringType ? "char" : toCType(iteratorSymbol.type),
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

            if(p.getClass() == IdNode.class){
                Symbol symbol = ST.retrieveSymbol(((IdNode) p).name);
                if(symbol.type instanceof IntType){
                    str +="%d";
                    endPart += (","+((IdNode) p).name);

                }else if(symbol.type instanceof StringType){
                    if(foreachDict.get(symbol.name) == "c"){
                        str +="%c";
                        endPart += (",*"+((IdNode) p).name);
                    }else{
                        str +="%s";
                        endPart += (","+((IdNode) p).name);
                    }
                }else if(symbol.type instanceof BoolType){
                    str +="%s";
                    endPart += ","+p.accept(this)+" ? \"true\" : \"false\"";
                }
                else {
                    System.out.println("Incompatible type for print");
                }
                //variables
            }else if(p instanceof ArithmeticExpression ){
                //arithmetic
                str +="%d";
                endPart += ","+p.accept(this);
            }else if(p instanceof BooleanExpression){
                //boolean
                str +="%s";
                endPart += ","+p.accept(this)+" ? \"true\" : \"false\"";
            }else if(p.getClass() == StringNode.class){
                //string literals
                str +="%s";
                endPart += ", \""+((StringNode) p).value+"\"";}

        };
        str += "\\n\""+endPart+")"+EOL;

        //char text[13] = " cars in the ";
        //printf("%d%s%s\n",2*2,text, "garage");
        return str;
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

        List<String> actualParams = new ArrayList<>();

        n.actualParameters.forEach(param ->
                actualParams.add((String) param.accept(this))
        );

        //Add a delimeter between the parameters
        String formattedParams = String.join(",", actualParams);

        return """
               %s(%s)
               """.formatted(
               n.actionName, formattedParams
        );

    }

    @Override
    public String visit(ReturnNode n) {
        return """
               return (%s);
               """.formatted(
                       n.returnVal.accept(this)
        );
    }

    @Override
    public String visit(FieldAccessNode n) {
        StringBuilder str = new StringBuilder();
        for (String field : n.fields) {
            str.append(field);
        }
        str.append(EOL);
        return str.toString();
    }
}
