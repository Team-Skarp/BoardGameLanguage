package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.SymbolTable;
import SymbolTable.TypeChecker;
import SymbolTable.TypeEnvironment;
import SymbolTable.Symbol;
import SymbolTable.types.*;
import SymbolTable.IllegalListAssignmentException;

import java.text.DecimalFormat;
import java.util.*;

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

    private final int           DEFAULT_LIST_SIZE = 25;

    /**
     * Flags for generating correct design & action signatures
     */
    private DesignDefinitionNode currentDesignDefinition = null;
    private ActionDefinitionNode currentActionDefinition = null;

    public CCodeGenerator(SymbolTable ST, TypeEnvironment TENV) {
        this.ST = ST;
        this.TENV = TENV;
    }

    @Override
    public String visit(GameNode n) {
        String userCode;
        header += """
               #include "%s"
               """.formatted("bgllib.h");

        //Everything in rules block gets put on top level in C code
        n.rules.accept(this);

        userCode =
                """
                        int main(int argc, char *argv[]) {
                            time_t t;
                           
                            /* Intializes random number generator */
                            srand((unsigned) time(&t));
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
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return (a+b)+"";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " + " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(MinusNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return (a-b)+"";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " - " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(UnaryMinusNode n) {
        return " ( -( "+n.operand.accept(this)+" ) ) ";
    }

    @Override
    public String visit(MultNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a*b+"";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " * " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(DivNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return Math.round(a/b)+"";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " / " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(ModNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return (a%b)+"";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " % " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(PowNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return Math.round(Math.pow(a,b))+"";
        }
        catch(NumberFormatException ex){
            return " ( (int)pow("+n.left.accept(this)+", "+n.right.accept(this)+") ) ";
        }
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
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a==b ? "true" : "false";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + "==" + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(NotEqualNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a!=b ? "true" : "false";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " != " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(LessThanNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a<b ? "true" : "false";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " < " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(GreaterThanNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a>b ? "true" : "false";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " > " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a>=b ? "true" : "false";
        }
        catch(NumberFormatException ex) {
            return " ( " + n.left.accept(this) + " >= " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            return a<=b ? "true" : "false";
        }
        catch(NumberFormatException ex){
            return " ( " + n.left.accept(this) + " <= " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(NegationNode n) {
        if(n.child.accept(this) == "true"){
            return "false";
        }else if(n.child.accept(this) == "false"){
            return "true";
        }
        return " ( !( "+n.child.accept(this)+" ) )";
    }

    @Override
    public String visit(OrNode n) {
        if(n.left.accept(this) == "true" && n.right.accept(this) == "true"){
            return "true";
        }else if(n.left.accept(this) == "false" && n.right.accept(this) == "true"){
            return "true";
        }else if(n.left.accept(this) == "true" && n.right.accept(this) == "false"){
            return "true";
        }else if(n.left.accept(this) == "false" && n.right.accept(this) == "false"){
            return "false";
        }else {
            return " ( " + n.left.accept(this) + " || " + n.right.accept(this) + " ) ";
        }
    }

    @Override
    public String visit(AndNode n) {
        if(n.left.accept(this) == "true" && n.right.accept(this) == "true"){
            return "true";
        }else if(n.left.accept(this) == "false" && n.right.accept(this) == "true"){
            return "false";
        }else if(n.left.accept(this) == "true" && n.right.accept(this) == "false"){
            return "false";
        }else if(n.left.accept(this) == "false" && n.right.accept(this) == "false"){
            return "false";
        }else{
            return " ( "+n.left.accept(this)+" && "+n.right.accept(this)+" ) ";
        }
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
    public String visit(AssignmentNode n) {
        return "%s = %s;".formatted(n.name, n.expression.accept(this));
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
        System.out.println("CCG in IntAssNode");
        StringBuilder str = new StringBuilder();

        IdNode left = n.getLeft();
        Symbol leftSymbol = ST.retrieveSymbol(left.name);

        // special logic to handle list to list assignment,
        // as our current grammar picks int assignment for this case of assigning the value of one identifier to another

        if (leftSymbol.type.getClass().equals(ListType.class)) {
//            System.out.println("leftSymbol.type.getClass is " + leftSymbol.type.getClass());

            IdNode right = (IdNode) n.getRight();
            Symbol rightSymbol = ST.retrieveSymbol(right.name);

            // the types of identifiers must match, probably already done in TC
            if (true) {
                // leftSymbol.type.toString().equals(rightSymbol.type.toString())

                /*System.out.println("types in CCG int assignment match");
                System.out.println("leftSymbol.type = " + leftSymbol.type);
                System.out.println("rightSymbol.type = " + rightSymbol.type);
                */

                // check that only allows non-nested lists in here
                if (leftSymbol.type.toString().contains("list:list") || rightSymbol.type.toString().contains("list:list")) {
                    throw new IllegalListAssignmentException("cannot C code generate for lists of lists in assignments");
                }

                // sizes of the two lists
                int leftSize = leftSymbol.value;
                int rightSize = rightSymbol.value;

                // only allow assignment of lists of the same size
                if (leftSize != rightSize) {
                    throw new IllegalListAssignmentException("List sizes in assignment not equal");
                }

                // for loop to assign values of right side list to left side list
                // symbol harvester now records the size of lists at declaration
                str.append("for (int i = 0; i < %d; i++) {%n".formatted(leftSize));
                str.append("\t%s[i] = %s[i]".formatted(left, right)).append(EOL);
                str.append("}\n");

                return str.toString();
            }
        }

        // here we don't have a list to list assignment
        str.append(n.id.name).append(" = ").append(n.aexpr.accept(this)).append(EOL);
        return str.toString();
    }

    @Override
    public String visit(BooleanAssignmentNode n) {
        return n.varName+" = "+n.bexpr.accept(this)+EOL;
    }

    @Override
    public String visit(DotAssignmentNode n) {
        System.out.println("code gen for dot ass %s = %s ".formatted(n.getLeft(), n.getRight()));
        StringBuilder str = new StringBuilder();
        str.append(n.fieldAccessLHNode.accept(this));
        str.append(" = ");
        str.append(n.getRight().accept(this));
        str.append(EOL);

        return str.toString();
    }

    @Override
    /**
     * Should only append to top level code
     */
    public String visit(DesignDefinitionNode n) {
        //Design declarations should be handled differently inside a design
        currentDesignDefinition = n;
        String designBody = "";
        indent++;
        for (Declaration field : n.fields) {
            designBody += TAB.repeat(indent) + field.accept(this);
        }
        indent--;

        if (n.parentDName != null) {
            definitions +=  """
                    struct %s {
                    struct %s parent;
                    %s};
                    """.formatted(
                    n.dName,
                    n.parentDName,
                    designBody,
                    n.dName
            );
        } else {
            definitions +=  """
                    struct %s {
                    %s};
                    """.formatted(
                    n.dName,
                    designBody,
                    n.dName
                    );
        }

        currentDesignDefinition = null;

        return "";
    }

    @Override
    public String visit(ActionDefinitionNode n) {

        String actionBody = (String) n.body.accept(this);

        //Flag indicating that all design declarations should not be extended. Important its after the action signature
        currentActionDefinition = n;

        //Actions definitions are put on the top of the C code. A prototype for the definition is also added
        definitions += """
               %s %s(%s) %s
               """.formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters),
                actionBody
        );

        //Seems to create conflicting types of methods
        /*prototypes += """
               %s %s(%s);
               """.formatted(
                toCType(n.returnType),
                n.name,
                toCParams(n.formalParameters)
        );*/

        currentActionDefinition = null;

        return "";
    }

    @Override
    public String visit(Declaration n) {
        return (String) n.accept(this);
    }

    @Override
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
            params = params.replaceAll("\n", "");
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

        String actionMapping = "";

        //Create action mappings if outside of design definition and action definitions
        if (currentDesignDefinition == null && currentActionDefinition == null) {
            SymbolTable initialST = TENV.receiveType(n.dName).fields;
            actionMapping = makeActionMapping(initialST, n.name, (DesignRef) n.type());
        }

        DesignType thisType = TENV.receiveType(n.dName);

        if (n.value != null) {

            // Cast parent param to struct of parent type
            if (n.value.get(0).contains("{") && n.value.get(0).contains("}")) {
                n.value.set(0,"(struct %s)%s".formatted(thisType.parent, n.value.get(0)));
            }

            // Joined string for init
            String collectedString = String.join(", ", n.value);

            return removeEmptyLines(
                    """
                    struct %s %s = {%s};
                    %s
                    """.formatted(n.dName, n.name, collectedString, actionMapping)
            );
        }

        if (hasSelfReference(n)) {
            //Add pointer to self, if design definition contains a reference to itself to handle incomplete C struct
            return removeEmptyLines(
                    """
                    struct %s *%s;
                    %s
                    """.formatted(n.dName, n.name, actionMapping)
            );
        }

        if (currentActionDefinition != null && currentActionDefinition.isMethodDefinition) {
            //If we are currently defining a method. The 1.st argument should be of pointer type
            return  """
                    struct %s *%s;
                    """.formatted(n.dName, n.name);
        }

        return removeEmptyLines(
                """
                struct %s %s;
                %s
                """.formatted(n.dName, n.name, actionMapping)
        );

    }

    /**
     * Checks weather or not the design definition have a reference to itself
     *
     * Ex: design Node {
     *     Node next; <-- References its own type
     *     Node prev;
     * }
     *
     * @param n
     * @return
     */
    private boolean hasSelfReference(DesignDeclarationNode n) {

        if (currentDesignDefinition == null) {
            return false;
        }

        return n.dName.equals(currentDesignDefinition.dName);
    }

    private String removeEmptyLines(String code) {

        return code.replaceAll("\n+", "\n");
    }

    /**
     * Maps every action in a design to the address of the C function
     *
     * design Animal {
     *     action eat();
     * }
     * design Dog {
     *     Animal parrent();
     *     action bark();
     * }
     *
     * Dog bulldog;
     *
     * -> bulldog.bark = &bark;
     * -> bulldog.parrent.eat = &eat;
     *
     * @return
     */
    private String makeActionMapping(SymbolTable localST, String lastFieldName, DesignRef lastFieldType) {
        String localMapping = "";
        SymbolTable next;
        for (Map.Entry<String, Symbol> entry : localST.getActiveBlock().getSymbolMapping().entrySet()) {
            if (entry.getValue().type instanceof DesignRef design) {
                next = TENV.receiveType(design.name).fields;

                //If the entry references our self, then skip going into it to prevent infinite loops
                boolean referencesSelf = Objects.equals(lastFieldType.name, design.name);
                if (!referencesSelf) {
                    localMapping += lastFieldName + "." + makeActionMapping(next, entry.getKey(), design);
                }
            }
            else if (entry.getValue().type instanceof ActionType) {
                localMapping += lastFieldName + "." + entry.getKey() + " = &" + entry.getKey() + ";\n";
            }
        }
        return localMapping;
    }

    /**
     * Method to figure out if a design contains a self reference
     *
     * If a the symbol table contains a design declaration that matches self return true, else false
     */
    private boolean referencesItself(String self, SymbolTable DST) {
        for (Map.Entry<String, Symbol> entry : DST.getActiveBlock().getSymbolMapping().entrySet()) {
            if (entry.getValue().type instanceof DesignRef design && design.name == self) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String visit(ListDeclarationNode n) {
        Symbol leftList;
        SymbolTable DST;

        if (currentDesignDefinition != null) {
            DST = TENV.receiveType(currentDesignDefinition.dName).fields;
            leftList = DST.retrieveSymbol(n.name);
        }
        else {
            leftList = ST.retrieveSymbol(n.name);
        }

        // C needs size set aside for array elements
        String braces = "[%d]".formatted(leftList.value > 0 ? leftList.value : DEFAULT_LIST_SIZE );
        TypeDenoter finalType = n.elementType;

        // prep to set size of nested arrays
        ListNode eleTemp = null;
        int size = 0;
        if (n.assignedList != null && n.assignedList.elements != null && n.assignedList.elements.size() != 0 ) {
            if (n.assignedList.elements.get(0) != null && n.assignedList.elements.get(0).getClass() == ListNode.class) {
                eleTemp = (ListNode) n.assignedList.elements.get(0);
                size = eleTemp.elements.size();
            }
        }
        //Algorithm to find the final type of a list
        while (finalType instanceof ListType) {
            // find first element in next list element
            if (eleTemp != null && eleTemp.elements.get(0).getClass() == ListNode.class) {
                eleTemp = (ListNode) eleTemp.elements.get(0);
            }

            ListType temp = (ListType) finalType;
            finalType = temp.elementType;
            braces += "[%d]".formatted(size);
            if (eleTemp != null) {
                size = eleTemp.elements.size();
            }
        }

        if (n.assignedList == null) {
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
        else {
            StringBuilder rightSide = new StringBuilder();
            rightSide.append("{");
            for (ASTNode child: n.assignedList.elements) {
                rightSide.append(child.accept(this));
                rightSide.append(", ");
            }
            if (!n.assignedList.elements.isEmpty()) {
                rightSide.deleteCharAt(rightSide.length()-1);
                rightSide.deleteCharAt(rightSide.length()-1);
            }
            rightSide.append("}");
            return (
                    """
                    %s %s%s = %s;
                    """.formatted(
                    toCType(finalType),
                    n.name,
                    braces,
                    rightSide.toString()
                    )
            );
        }
    }

    @Override
    public String visit(ListNode n) {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (ASTNode elementNode: n.elements) {
            str.append(elementNode.accept(this));
            str.append(", ");
        }
        if (!n.elements.isEmpty()) {
            str.deleteCharAt(str.length()-1);
            str.deleteCharAt(str.length()-1);
        }


        str.append("}");

        return str.toString();
    }

    @Override
    public String visit(ListElementNode n) {
        StringBuilder str = new StringBuilder();
        str.append("{");

        for (ASTNode elementNode: n.children) {
            str.append(elementNode);
            str.append(", ");
        }
        if (!n.children.isEmpty())
        str.deleteCharAt(str.length()-1);

        str.append("}");
        //str.append(EOL); // Commenting this out seemingly makes no difference... weird
        return str.toString();
    }

    @Override
    public String visit(IndexAccessNode n) {

        StringBuilder str = new StringBuilder();

        for (ASTNode child: n.value) {
            //Subtract one as BGL is 1 indexed
            str.append("[%s - 1]".formatted(child.accept(this)));
        }

        return str.toString();
    }


    @Override
    public String visit(ListIndexAssignmentNode n) {
        return null; // Todo: implement
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
            //int a;
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
                } else if(symbol.type instanceof StringType){
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
            }else if(p instanceof ArithmeticExpression aExpr ){
                TypeChecker TC = new TypeChecker(ST, TENV);
                TypeDenoter t = (TypeDenoter) aExpr.accept(TC);
                String RHS = (String) p.accept(this);

                //use correct format specifier
                if (t instanceof IntType) {
                    str += "%d";
                }
                else if (t instanceof StringType) {
                    str += "%s";
                }

                endPart += "," + RHS;
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
               %s(%s);
               """.formatted(n.actionName, formattedParams);

    }

    @Override
    public String visit(MethodCallNode n) {
        List<String> actualParams = new ArrayList<>();

        //Actual parameters contains self as the first argument
        n.actualParameters.forEach(param ->
                actualParams.add((String) param.accept(this))
        );

        //Add address to self argument
        String self = "&" + actualParams.get(0);
        actualParams.remove(0);
        actualParams.add(0, self);

        //Add a delimeter between the parameters
        String formattedParams = String.join(",", actualParams);

        return """
               %s(%s);
               """.formatted(n.actionName, formattedParams);
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
        boolean oneIdNodeHasBeenAppended = false;

        StringBuilder str = new StringBuilder();

        for (ASTNode node : n.fields) {
            if (node instanceof IdNode IdN) {
                if (oneIdNodeHasBeenAppended) {
                    str.append(".");
                }
                str.append(IdN.name);
                oneIdNodeHasBeenAppended = true;

            }
            else if (node instanceof IndexAccessNode) {
                str.append(node.accept(this));
            }
            else if (node instanceof MethodCallNode) {
                if (oneIdNodeHasBeenAppended) {
                    str.append(".");
                }
                str.append(node.accept(this));
            }
        }

        return str.toString();
    }

    @Override
    public String visit(FieldAccessLHNode n) {
        // List<String> children = new ArrayList<>();
        boolean oneIdNodeHasBeenAppended = false;

        StringBuilder str = new StringBuilder();

        for (ASTNode node : n.fields) {
            if (node instanceof IdNode IdN) {
                if (oneIdNodeHasBeenAppended) {
                    str.append(".");
                }
                str.append(IdN.name);
                oneIdNodeHasBeenAppended = true;
            //children.add((String)field.accept(this));
            }
            else if (node instanceof IndexAccessNode) {

                str.append(node.accept(this));
            }
        }

        return str.toString();
    }

    @Override
    public String visit(ExitNode n) {
        return """
               exit(EXIT_SUCCESS);
               """;
    }

    @Override
    public String visit(RandomNode n) {
        String str = "(rand() % ";
        str += "%s + 1)".formatted(n.diceSize.accept(this));
        return str;
    }

    @Override
    public String visit(SizeOfNode n) {
        //Give back the number of elements found in the identifier
        Symbol identifier = ST.retrieveSymbol(n.var);
        return "%d".formatted(identifier.value);

    }
}
