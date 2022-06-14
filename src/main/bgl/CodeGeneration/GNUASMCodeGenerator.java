package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;
import SymbolTable.types.StringType;
import SymbolTable.types.VoidType;
import java.util.HashMap;

public class GNUASMCodeGenerator implements ASTvisitor<String> {

    private SymbolTable ST;
    private int             indent = 0;
    private final String    TAB = "\t";
    Logger lo =             new Logger();
    private final String EOL = ";\n";
    private PrintNode printNode;
    //where string data is stored
    String data;
    //bottom of the program
    String footer;
    //a list of all declared functions
    String functions;
    //an incrementer to keep count of functions
    int functionCounter = 7;
    //indicates how many variables have been declared in data section
    int dataAmount = 2;
    //pointer offset for the register
    int pointerOffset = 20;
    //indicates how many LC parts there has been. L is places you commonly jmp to
    int LAmount = 2;
    //creates a hashmap between a symbol from the symbol table and its pointer for assembly
    HashMap<Integer,Integer> ptrTable = new HashMap<Integer, Integer>();
    //hashtable for conditional statements, such that no dangling else problems arise
    HashMap<Integer,Integer> condTable = new HashMap<Integer, Integer>();
    //Hashtable for strings, used in conjunction with ptrtable, e.g. str a -> 32 -> "hej"
    HashMap<Integer,String> strTable = new HashMap<Integer, String>();
    //this is the most recently called name of the variable from id node
    String lastIdNode;
    //this is the last ptr used
    int ptr = 0;
    public GNUASMCodeGenerator(SymbolTable ST) {
        this.ST = ST;
    }

    @Override
    public String visit(GameNode n) {
                data = """
                	.file	"out.c"
                	.intel_syntax noprefix
                	.text
                	.globl	main
                	.type main, @function
                	.section .rodata
                .LC0:
                    .string	"true"
                .LC1:
                    .string	"false"
                """;
                functions = """
                        """;
                String str = n.setup.accept(this)+"";
                str += n.rules.accept(this);
                str+= """
                        .GAMELOOP:
                        %s
                            jmp .GAMELOOP
                        """.formatted(n.gameloop.accept(this));
                footer = """
                  	leave
                 	mov	eax, 0
                	.cfi_def_cfa 7, 8
                	ret
                	.cfi_endproc
                .LFE6:
                	.size	main, .-main
                	.ident	"GCC: (Ubuntu 9.4.0-1ubuntu1~20.04.1) 9.4.0"
                	.section	.note.GNU-stack,"",@progbits
                	.section	.note.gnu.property,"a"
                	.align 8
                	.long	 1f - 0f
                	.long	 4f - 1f
                	.long	 5
                	%s
                0:
                	.string	 "GNU"
                1:
                	.align 8
                	.long	 0xc0000002
                	.long	 3f - 2f
                2:
                	.long	 0x3
                3:
                	.align 8
                4:
                """.formatted(functions);

                //make sure we subtract the right amount so not to get segmentation fault
                int subrsp = 8;
                while(pointerOffset > subrsp){
                    subrsp*=2;
                }
        String initialize = """
                main:
                .LFB6:
                	.cfi_startproc
                	endbr64
                	push	rbp
                	.cfi_def_cfa_offset 16
                	.cfi_offset 6, -16
                	mov	rbp, rsp
                	.cfi_def_cfa_register 6
                	sub rsp, %d
                	mov	DWORD PTR -%d[rbp], edi
                 	mov	QWORD PTR -%d[rbp], rsi
                """.formatted(subrsp,pointerOffset,pointerOffset+12);
        data += """
                            .text
                            .type	main, @function
                        """;
        return data+initialize+str+footer;
    }

    @Override
    public String visit(Expression n) {
        return null;
    }

    @Override
    public String visit(ArithmeticExpression n) {
        return null;
    }

    @Override
    public String visit(PlusNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = a+b;
            return result+"";
        }
        catch (NumberFormatException ex){

            String str = """
                    0
                    mov eax, %s
                    add eax, %s
                    cmp ebx, eax
                    """.formatted(n.left.accept(this),n.right.accept(this));
            return str;
        }
    }

    @Override
    public String visit(MinusNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = a-b;
            return result+"";
        }
        catch (NumberFormatException ex){
            String str = """
                    0
                    mov eax, %s 
                    sub eax, %s
                    cmp ebx, eax
                    """.formatted(n.left.accept(this),n.right.accept(this));
            return str;
        }
    }

    @Override
    public String visit(UnaryMinusNode n) {
        return "-"+n.operand.accept(this);
    }

    @Override
    public String visit(MultNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = a*b;
            return result+"";
        }
        catch (NumberFormatException ex){
            String str = """
                    0
                    mov eax, %s 
                    imul eax, %s
                    cmp ebx, eax
                    """.formatted(n.left.accept(this),n.right.accept(this));
            return str;
        }
    }

    @Override
    public String visit(DivNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = (int) Math.floor(a/b);
            return result+"";
        }
        catch (NumberFormatException ex){
            String str = """
                    0
                    mov eax, %s
                    cdq
                    mov ebx, %s 
                    idiv ebx
                    cmp ebx, eax
                    """.formatted(n.left.accept(this),n.right.accept(this));
            return str;
        }
    }

    @Override
    public String visit(ModNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = a%b;
            return result+"";
        }
        catch (NumberFormatException ex){
            String str = """
                    0
                    mov eax, %s
                    cqo
                    mov ebx, %s 
                    idiv ebx
                    mov eax, edx
                    cmp ebx, eax
                    """.formatted(n.left.accept(this),n.right.accept(this));
            return str;
        }
    }

    @Override
    public String visit(PowNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = 1;
            for (int i = 0; i < b; i++){
                result *=a;
            }
            return result+"";
        }
        catch (NumberFormatException ex){
            LAmount+=2;
            pointerOffset += 4;
            ptr = pointerOffset-16;
            int temp = LAmount-1;
            String str = """
                    0
                    	mov ebx, 1 
                    	mov eax, %s
                    	mov  DWORD PTR -%d[rbp], eax
                    	jmp .L%d
                    .L%d:
                    	inc ebx
                    	imul eax, DWORD PTR -%d[rbp]
                    .L%d:
                    	cmp ebx, %s
                    	jne .L%d
                        cmp ebx, eax
                    """.formatted(n.left.accept(this),ptr,temp+1,temp,ptr,temp+1,n.right.accept(this),temp);
            return str;
        }
    }
    @Override
    public String visit(IdNode n) {
        Symbol symbol = ST.retrieveSymbol(n.name);
        lastIdNode = n.name;
        return "DWORD PTR -%d[rbp]".formatted(ptrTable.get(symbol.hashCode()));
    }

    @Override
    public String visit(IntNode n) {
        String str = n.value+"";
        return str;
    }

    @Override
    public String visit(BooleanNode n) {
        if(n.value == true){
            return "0";
        }else{
            return "-1";
        }
    }

    @Override
    public String visit(StringNode n) {
        return n.value;
    }

    @Override
    public String visit(BooleanExpression n) {
        return null;
    }

    @Override
    public String visit(EqualNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a == b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	jne .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            //TODO: do i for variables
            return str;
        }
    }

    @Override
    public String visit(NotEqualNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a != b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	je .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            return str;
        }
    }

    @Override
    public String visit(LessThanNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a < b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	jle .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            return str;
        }
    }

    @Override
    public String visit(GreaterThanNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a > b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	jge .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            return str;
        }
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a >= b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	jl .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            return str;
        }
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            if(a <= b){
                return "0";
            }else{
                return "-1";
            }
        }
        catch (NumberFormatException ex){
            LAmount++;
            String str = """
                    -1
                    	mov ebx, %s
                    	cmp ebx, %s
                    	jl .L%d
                    	mov eax, 0
                    .L%d:
                    """.formatted(n.right.accept(this),n.left.accept(this),LAmount,LAmount);
            LAmount++;
            return str;
        }
    }

    @Override
    public String visit(NegationNode n) {
        if(n.child.accept(this) == "0"){
            return "-1";
        }else if(n.child.accept(this) == "-1"){
            return "0";
        }else {
            return """
                    %s
                    not eax
                    """.formatted(n.child.accept(this));
        }
    }

    @Override
    public String visit(OrNode n) {
        if((n.left.accept(this) == "-1" && n.right.accept(this) == "0")||
                (n.left.accept(this) == "0" && n.right.accept(this) == "-1")||
                (n.left.accept(this) == "0" && n.right.accept(this) == "0")){
            return "0";
        }else if((n.left.accept(this) == "-1" && n.right.accept(this) == "-1")){

            return "-1";
        }else{
            return """
                    %s
                    mov ecx, eax
                    mov eax, %s
                    and eax, ecx
                    """.formatted(n.left.accept(this),n.right.accept(this));
        }
    }

    @Override
    public String visit(AndNode n) {
        if(n.left.accept(this) == "0" && n.right.accept(this) == "0"){
            return "0";
        }else if((n.left.accept(this) == "-1" && n.right.accept(this) == "0")||(n.left.accept(this) == "0" && n.right.accept(this) == "-1")||(n.left.accept(this) == "-1" && n.right.accept(this) == "-1")){
            return "-1";
        }else{
            return """
                    %s
                    mov ecx, eax
                    mov eax, %s
                    or eax, ecx
                    """.formatted(n.left.accept(this),n.right.accept(this));
        }
    }

    @Override
    public String visit(BlockNode n) {
        String str = "";
        //Go down into the scope of this block
        ST.dive();
        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }
        //When finished, climb back to parrent scope
        ST.climb();
        return str;
    }

    @Override
    public String visit(ParameterBlock n) {
        String str = "";
        //Go down into the scope of this block
        ST.dive();
        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }
        //When finished, climb back to parrent scope
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
        return null;
    }

    @Override
    public String visit(StringAssignmentNode n) {
        dataAmount++;
        int temp = dataAmount;
        dataAmount++;
        Symbol symbol = ST.retrieveSymbol(n.varName);
        ptrTable.put(symbol.hashCode(),temp);
            data+= """
                    .LC%d:
                        .string %s
                    """.formatted(temp,n.literal);
            strTable.put(temp,n.literal);
        return "";
    }

    @Override
    public String visit(IntegerAssignmentNode n) {
        Symbol symbol = ST.retrieveSymbol(n.id.name);
        String str = """
                	mov eax, %s
                	mov	DWORD PTR -%d[rbp],eax
                """.formatted(n.aexpr.accept(this),ptrTable.get(symbol.hashCode()));
        return str;
    }

    @Override
    public String visit(BooleanAssignmentNode n) {
        Symbol symbol = ST.retrieveSymbol(n.varName);
        String str = """
                	mov eax, %s
                	mov	DWORD PTR -%d[rbp],eax
                """.formatted(n.bexpr.accept(this),ptrTable.get(symbol.hashCode()));
        return str;
    }

    @Override
    public String visit(DotAssignmentNode n) {
        return null; //Todo: no time to implement this
    }

    @Override
    public String visit(ListIndexAssignmentNode n) {
        return null;
    }

    @Override
    public String visit(DesignDefinitionNode n) {
        return null;
    }

    @Override //Actions are functions
    public String visit(ActionDefinitionNode n) {

        //TODO: switch depending on return type
        //TODO: insert formalparameters if they exist
        //TODO: returntype
        functionCounter++;
        int stackPtr = 16;
        String formalParameters = "";
        for(ASTNode child: n.formalParameters){
            String variable = (String)child.accept(this);
            if(child instanceof IntegerDeclarationNode){
                formalParameters += """
                    %s
                        mov eax, DWORD PTR %d[rbp] 
                        %s eax
                    """.formatted(variable,stackPtr,variable.substring(4,variable.length()-2));
            }else if(child instanceof BooleanDeclarationNode){
                formalParameters += """
                    %s
                        mov eax, DWORD PTR %d[rbp] 
                        mov DWORD %s eax
                    """.formatted(variable,stackPtr,variable.substring(9,variable.length()-4));
            }
            stackPtr+=8;
        }

        String functionBlock = "";
        for (ASTNode child: n.body.children){
            functionBlock+=child.accept(this);
        }
        functions += """
                	.section .rodata
                	.text
                	.globl	%s                
                	.type	%s, @function     
                %s:                           
                .LFB%d:                          
                	.cfi_startproc
                	endbr64	
                	push	rbp	
                	.cfi_def_cfa_offset 16
                	.cfi_offset 6, -16
                	mov	rbp, rsp	
                	.cfi_def_cfa_register 6
                	%s
                    %s
                	call 	puts@PLT
                	nop	
                	pop	rbp	
                	.cfi_def_cfa 7, 8
                	ret	
                	.cfi_endproc
                .LFE%d:                          
                	.size	%s, .-%s        
                """.formatted(n.name,n.name,n.name,functionCounter,formalParameters,functionBlock,functionCounter,n.name,n.name);

        return "";
    }

    @Override
    public String visit(Declaration n) {
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
    public String visit(ListDeclarationNode n) {
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
        pointerOffset += 4;
        ptr = pointerOffset-16;
        String str = "";
        if(n.value == null){
            lo.g("1");
            str +="""
                        mov	DWORD PTR -%d[rbp], 0
                    """.formatted(ptr);
        }
        else if(((String)n.value.accept(this)).contains("DWORD")){
            str+= """
                        mov eax, %s
                        mov	DWORD PTR -%d[rbp], eax
                    """.formatted(n.value.accept(this),ptr);
        }else{
            str+= """
                        mov	DWORD PTR -%d[rbp], %s
                    """.formatted(ptr,n.value.accept(this));
        }


        //String str = "    mov DWORD PTR -%d[rbp], 0\n".formatted(ptr)+n.value.accept(this)+"\n";
        Symbol symbol = ST.retrieveSymbol(n.name);
        ptrTable.put(symbol.hashCode(),ptr);
        return str;
    }

    @Override
    public String visit(BooleanDeclarationNode n) {
        pointerOffset += 4;
        int ptr = pointerOffset-16;
        String str = "";
        if(n.value == null){
            str+= """
                    mov	BYTE PTR -%d[rbp], -1
                    """.formatted(ptr);
        }
        else if(((String)n.value.accept(this)).contains("DWORD")){
            str+= """
                        mov	BYTE PTR -%d[rbp], -1
                        mov	eax, %s
                        mov	DWORD PTR -%d[rbp],eax
                        mov eax, 0
                    """.formatted(ptr,n.value.accept(this),ptr);
        }else{
            str+= """
                    mov	BYTE PTR -%d[rbp], %s
                    """.formatted(ptr,n.value.accept(this));
        }
        Symbol symbol = ST.retrieveSymbol(n.name);
        ptrTable.put(symbol.hashCode(),ptr);
        return str;
    }

    @Override
    public String visit(StringDeclarationNode n) {
        dataAmount++;
        int temp = dataAmount;
        dataAmount++;
        Symbol symbol = ST.retrieveSymbol(n.name);
        ptrTable.put(symbol.hashCode(),temp);
        if(n.value == null){
            data+= """
                    .LC%d:
                        .string	""
                    """.formatted(temp);
            strTable.put(temp,"");
        }
        else if(((String)n.value.accept(this)).contains("DWORD")){
            data+= """
                    .LC%d:
                        .string	"%s"
                    """.formatted(temp,strTable.get(ptrTable.get(ST.retrieveSymbol(lastIdNode).hashCode())));
            //missing string table
        }else{
            String str = (String)n.value.accept(this);
            data+= """
                    .LC%d:
                        .string	"%s"
                    """.formatted(temp,str);
            strTable.put(temp,str);
        }
        return "";
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
        LAmount++;
        condTable.put(n.ifBlock.hashCode(),LAmount);
        LAmount++;
        int ifstmntLoc = LAmount;
        String str = """
                    \n
                	mov eax, %s
                	cmp	eax, 0
                	jne	.L%d
                	%s
                	jmp	.L%d
                 .L%d:
                """.formatted(n.predicate.accept(this),ifstmntLoc,n.ifBlock.accept(this),condTable.get(n.ifBlock.hashCode()),ifstmntLoc);
        LAmount++;
        if(n.elseifBlocks.size() >0) {
            for (ASTNode elseif : n.elseifBlocks) {
                LAmount++;
                str += """
                        	%s
                        	jmp	.L%d
                         .L%d:
                        """.formatted(elseif.accept(this), condTable.get(n.ifBlock.hashCode()), LAmount);
                LAmount++;
            }
        }

        if(n.elseBlock != null){
            str+= """
                    %s
                    """.formatted(n.elseBlock.accept(this));
        }

        return str+ """
                 .L%d:
                """.formatted(condTable.get(n.ifBlock.hashCode()));
    }

    @Override
    public String visit(ElifConditionalNode n) {
        String str = """
                	mov eax, %s
                	cmp	eax, 0
                	jne	.L%d
                	%s
                """.formatted(n.predicate.accept(this),LAmount,n.ifBlock.accept(this));
        return str;
    }

    @Override
    public String visit(ElseNode n) {
        n.elseBlock.accept(this);
        return "";
    }

    @Override
    public String visit(PredicateNode n) {
        return null;
    }

    @Override
    public String visit(WhileNode n) {
        LAmount+=2;
        int temp = LAmount-1;
        String str = """
                	jmp	.L%d
                .L%d:
                	%s
                .L%d:
                    mov eax, %s
                	cmp	eax, 0
                	je	.L%d
                	mov	eax, 0
                """.formatted(temp+1,temp,n.whileBlock.accept(this),temp+1,n.predicate.accept(this),temp);
        LAmount+=2;

        return str;
    }

    @Override
    public String visit(ForeachNode n) {
        return null;
    }

    @Override
    public String visit(PrintNode n) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        LAmount++;
        printNode = n;
        String str = "";
        String EOL = "";
        int printCount = 1;
        for (ASTNode p : n.prints){
            Symbol symbol = new Symbol("print", new VoidType());
            if(p.getClass() == IdNode.class){
                symbol = ST.retrieveSymbol(((IdNode) p).name);
            }
            if(printCount == n.prints.size()){
                EOL = "\\n";
            }
            if(p.getClass() == StringNode.class){
                //STRING
                data +="""
                        .LC%d:
                            .string	"%s"
                        """.formatted(dataAmount,((StringNode) p).value+EOL);
                str += "    mov	esi, eax";
            }else if(p.getClass() == IdNode.class){
                //ID NODES
                if(symbol.type instanceof IntType){
                    //ID TYPE INT
                    data +="""
                        .LC%d:
                            .string	"%s"
                        """.formatted(dataAmount,"%d"+EOL);
                    str += """
                                mov eax, DWORD PTR -%d[rbp]
                                mov	esi, eax
                            """.formatted(ptrTable.get(symbol.hashCode()));
                }else if(symbol.type instanceof BoolType){
                    //ID TYPE BOOL
                    data +="""
                        .LC%d:
                            .string	"%s"
                        """.formatted(dataAmount,"%s"+EOL);
                    str += """
                        	cmp	BYTE PTR -%d[rbp], -1
                        	je	.L%d
                        	lea	rax, .LC0[rip]
                        	jmp	.L%d
                        .L%d:
                        	lea	rax, .LC1[rip]
                        .L%d:
                            mov rsi, rax
                        """.formatted(ptrTable.get(symbol.hashCode()),LAmount,LAmount+1,LAmount,LAmount+1);
                    LAmount+=2;
                }else if(symbol.type instanceof StringType){
                    //ID TYPE STRING

                    //dont need anything here
                }
            }else if(p instanceof BooleanExpression){
                // BOOL
                data +="""
                        .LC%d:
                            .string	"%s"
                        """.formatted(dataAmount,"%s"+EOL);
                str += """
                            mov eax, %s
                        	cmp	eax, 0
                        	jne	.L%d
                        	lea	rax, .LC0[rip]
                        	jmp	.L%d
                        .L%d:
                        	lea	rax, .LC1[rip]
                        .L%d:
                            mov rsi, rax
                        """.formatted(p.accept(this),LAmount,LAmount+1,LAmount,LAmount+1);
                LAmount+=2;
            }else if(p instanceof ArithmeticExpression){
                //int
                data +="""
                        .LC%d:
                            .string	"%s"
                        """.formatted(dataAmount,"%d"+EOL);
                str += """
                            mov eax, %s
                            mov	esi, eax
                        """.formatted(p.accept(this));
                LAmount++;
            }
            str +="""
                    \n
                    lea	rdi, .LC%d[rip]
                	mov	eax, 0
                	call printf@PLT
                """.formatted((symbol.type instanceof StringType) ? ptrTable.get(symbol.hashCode()): dataAmount);
            dataAmount++;
            printCount++;
        }

        return str;
    }

    @Override
    public String visit(InputNode n) {
        dataAmount++;
        Symbol symbol = ST.retrieveSymbol(n.inputVariableName.name);
        String str = "";
        if(symbol.type instanceof IntType){
            data += """
                    .LC%d:
                    	.string	"%s"
                    """.formatted(dataAmount,"%d");
            str += """
                	lea	rax, -%d[rbp]
                	mov	rsi, rax	
                	lea	rdi, .LC%d[rip]
                	mov	eax, 0
                	call	__isoc99_scanf@PLT
                """.formatted(ptrTable.get(symbol.hashCode()),dataAmount);
        }else if(symbol.type instanceof BoolType){
            pointerOffset += 4;
            ptr = pointerOffset-16;
            LAmount++;
            data += """
                    .LC%d:
                    	.string	"%s" 
                    """.formatted(dataAmount,"%d");
            str += """
                    mov	DWORD PTR -%d[rbp], 1
                    lea rax, -%d[rbp]
                    mov	rsi, rax
                    lea	rdi, .LC%d[rip]
                    mov	eax, 0
                    call	__isoc99_scanf@PLT
                    mov	BYTE PTR -%d[rbp], -1	
                    cmp DWORD PTR -%d[rbp], 0
                    jle .L%d
                    mov	BYTE PTR -%d[rbp], 0
                .L%d:
                """.formatted(ptr,ptr,dataAmount,ptrTable.get(symbol.hashCode()),ptr,LAmount,ptrTable.get(symbol.hashCode()),LAmount);
            ptr+=4;
            LAmount++;
        }else if(symbol.type instanceof StringType){
            //TODO: complete string input

        }
        dataAmount+=1;
        return str;
    }

    @Override
    public String visit(ActionCallNode n) {
        String parameters = """
                """;
        for(ASTNode parameter: n.actualParameters){
            String parm = parameter.accept(this).toString();
            if(parm.contains("DWORD")){
                parm = "Q"+parm.substring(1);
            }
            parameters+= """
                    \npush %s""".formatted(parm);
        }
        String str = """
                	%s
                	call %s	
                	mov	eax, 0
                """.formatted(parameters,n.actionName);
        return str;
    }

    @Override
    public String visit(MethodCallNode n) {
        return null;
    }

    @Override
    public String visit(ReturnNode n) {
        String str = """
                mov eax, %s
                """.formatted(n.returnVal.accept(this));
        return str;
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
                Symbol symbol = ST.retrieveSymbol(IdN.name);
                String var = "DWORD PTR -%d[rbp]".formatted(ptrTable.get(symbol.hashCode()));
                str.append(var);
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
        return null;
    }

    @Override
    public String visit(ListElementNode n) {
        return null;
    }

    @Override
    public String visit(ListNode n) {
        return null;
    }

    @Override
    public String visit(IndexAccessNode n) {
        return null;
    }

    @Override
    public String visit(ExitNode n) {
        return null;
    }

    @Override
    public String visit(RandomNode n) {
        return null;
    }

    @Override
    public String visit(SizeOfNode n) {
        return null;
    }
}
