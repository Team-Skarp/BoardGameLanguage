package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;
import SymbolTable.Block;
import SymbolTable.Symbol;
import SymbolTable.SymbolTable;
import SymbolTable.types.BoolType;
import SymbolTable.types.IntType;
import SymbolTable.types.StringType;
import SymbolTable.types.VoidType;
import com.sun.jdi.IntegerType;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.HashMap;
import java.util.List;

public class GNUASMCodeGenerator implements ASTvisitor<String> {

    private SymbolTable ST;
    private int             indent = 0;
    private final String    TAB = "\t";
    Logger lo =             new Logger();
    private final String EOL = ";\n";
    private PrintNode printNode;
    String data;
    String footer;
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
    //this is the pointer currently used to declare a variable
    int assignPtr = 0;
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
                	.section	.rodata
                .LC0:
                    .string	"true"
                .LC1:
                    .string	"false"
                """;
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
                """;
        String str = n.setup.accept(this)+"";

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
                	sub	rsp, 16
                	mov	DWORD PTR -%d[rbp], edi
                 	mov	QWORD PTR -%d[rbp], rsi
                """.formatted(pointerOffset,pointerOffset+12);
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
        //String str = " ( "+n.left.accept(this)+" + "+n.right.accept(this)+" ) ";
        /*pointerOffset += 4;
        ptr = pointerOffset-16;
        String str = (n.left.getClass() == IntNode.class || n.left.getClass() == UnaryMinusNode.class) ? "\n\tadd DWORD PTR -%d[rbp], %s".formatted(ptr,n.left.accept(this)) : (String) n.left.accept(this);
        str += (n.right.getClass() == IntNode.class || n.right.getClass() == UnaryMinusNode.class) ? "\n\tadd DWORD PTR -%d[rbp], %s".formatted(ptr,n.right.accept(this)) : (String) n.right.accept(this);
        */
        try{
            int a = Integer.parseInt((String)n.left.accept(this));
            int b = Integer.parseInt((String)n.right.accept(this));
            int result = a+b;
            return result+"";
        }
        catch (NumberFormatException ex){

            System.out.println(n.left.accept(this)+" -- "+n.right.accept(this));
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
        //String str = " ( "+n.left.accept(this)+" - "+n.right.accept(this)+" ) ";
        /*String str = (n.left.getClass() == IntNode.class || n.left.getClass() == UnaryMinusNode.class) ? "\n\tadd DWORD PTR -%d[rbp], %s".formatted(ptr,n.left.accept(this)) : (String) n.left.accept(this);
        str += (n.right.getClass() == IntNode.class || n.right.getClass() == UnaryMinusNode.class) ? "\n\tsub DWORD PTR -%d[rbp], %s".formatted(ptr,n.right.accept(this)) : (String) n.right.accept(this);
        */
        //return str;
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
        //String str = " ( -( "+n.operand.accept(this)+" ) ) ";
        return "-"+n.operand.accept(this);
    }

    @Override
    public String visit(MultNode n) {
        //String str = " ( "+n.left.accept(this)+" * "+n.right.accept(this)+" ) ";
        //(n.left.getClass() == IntNode.class || n.left.getClass() == UnaryMinusNode.class) ? "\n\tsub DWORD PTR -%d[rbp], %s".formatted(ptr,n.left.accept(this)) : (String) n.left.accept(this);
        /*ptr = pointerOffset-16;
        String str2 = """
                    %s
                	mov	eax, DWORD PTR -%d[rbp]
                	sub eax, 2
                	mov	DWORD PTR -%d[rbp], 0	
                	jmp	.L%d
                .L%d:
                	add	DWORD PTR -%d[rbp], ebx
                	add	DWORD PTR -%d[rbp], 1	
                .L%d:
                	cmp	DWORD PTR -%d[rbp], eax
                	jle	.L%d
                """.formatted((n.left.getClass() == IntNode.class || n.left.getClass() == UnaryMinusNode.class) ? "\n\tadd DWORD PTR -%d[rbp], %s".formatted(ptr,n.left.accept(this)) : (String) n.left.accept(this)
                        ,ptr,ptr+4,LAmount,LAmount+1,ptr+8,ptr+4,LAmount,ptr+4,LAmount+1);
        LAmount+=2;
        pointerOffset += 8;
        ptr = pointerOffset-16;
        String str1 = """
                mov DWORD PTR -%d[rbp], 0
                %s
                mov ebx, DWORD PTR -%d[rbp]     
                """.formatted(ptr,
                (n.right.getClass() == IntNode.class || n.right.getClass() == UnaryMinusNode.class) ? "\n\tadd DWORD PTR -%d[rbp], %s".formatted(ptr,n.right.accept(this)) : (String) n.right.accept(this)
                ,ptr);

        return str1+str2;*/
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
        /*String str = """
                	mov eax, DWORD PTR -%d[rbp]
                	imul eax, %s
                	mov DWORD PTR -8[rbp], eax
                """.formatted(ptr);*/
    }

    @Override
    public String visit(DivNode n) {
        //String str = " ( "+n.left.accept(this)+" / "+n.right.accept(this)+" ) ";
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
        //String str = " ( "+n.left.accept(this)+" % "+n.right.accept(this)+" ) ";
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
       /* String str = """
                	mov	DWORD PTR -%d[rbp], %s
                	mov	DWORD PTR -%d[rbp], %s
                	mov	eax, DWORD PTR -%d[rbp]	
                	mov	DWORD PTR -%d[rbp], eax	
                	mov	DWORD PTR -%d[rbp], 1	
                	jmp	.L%d	
                .L%d:
                	mov	eax, DWORD PTR -%d[rbp]	
                	mov	DWORD PTR -%d[rbp], eax	
                	mov	DWORD PTR -%d[rbp], 1	
                	jmp	.L%d	
                .L%d:
                	mov	eax, DWORD PTR -%d[rbp]	
                	add	DWORD PTR -%d[rbp], eax	
                	add	DWORD PTR -%d[rbp], 1	
                .L%d:
                	mov	eax, DWORD PTR -%d[rbp]	
                	cmp	eax, DWORD PTR -%d[rbp]	
                	jl	.L%d	
                	add	DWORD PTR -%d[rbp], 1
                .L%d:
                	mov	eax, DWORD PTR -%d[rbp]	
                	cmp	eax, DWORD PTR -%d[rbp]	
                	jl	.L%d
                """.formatted(ptrVarDecl,n.left.accept(this),ptr+12,n.right.accept(this),ptrVarDecl,ptr+8,ptr+20,LAmount,LAmount+3,
                    ptrVarDecl, ptr+4, ptr+16,LAmount+1,LAmount+2,ptr+4,ptrVarDecl,ptr+16,LAmount+1,ptr+16,ptr+8,LAmount+2,ptr+20
                    ,LAmount,ptr+20,ptr+12,LAmount+3
                    );
        pointerOffset += 24;
        ptr = pointerOffset-16;
        LAmount+=4;*/
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
        //String str = ""+n.right.accept(this);
        //return str;
    }
    @Override
    public String visit(IdNode n) {
        System.out.println("idnode");
        Symbol symbol = ST.retrieveSymbol(n.name);
        lastIdNode = n.name;
        return "DWORD PTR -%d[rbp]".formatted(ptrTable.get(symbol.hashCode()));
    }

    @Override
    public String visit(IntNode n) {
        System.out.println("int node - "+n.value);
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
        /*String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "(!("+a+">"+b+")&&!("+a+"<"+b+"))";
        return str;*/
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
        /*String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "(("+a+">"+b+")||("+a+"<"+b+"))";
        return str;*/
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
        /*String str = " ( "+n.left.accept(this)+" < "+n.right.accept(this)+" ) ";
        return str;*/
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
        /*String str = " ( "+n.left.accept(this)+" > "+n.right.accept(this)+" ) ";
        return str;*/
        System.out.println(n.left.accept(this));
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
        /*String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "((!("+a+">"+b+")&&!("+a+"<"+b+"))||("+a+">"+b+"))";
        return str;*/
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
        /*String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "((!("+a+">"+b+")&&!("+a+"<"+b+"))||("+a+"<"+b+"))";
        return str;*/
        /*if(n.left.accept(this) <= n.right.accept(this)){
            return "1";
        }else{
            return "0";
        }*/
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
        /*String str = " ( !( "+n.child.accept(this)+" ) )";
        return str;*/
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
        /*String str = " ( "+n.left.accept(this)+" || "+n.right.accept(this)+" ) ";
        return str;*/
        if((n.left.accept(this) == "-1" && n.right.accept(this) == "0")||
                (n.left.accept(this) == "0" && n.right.accept(this) == "-1")||
                (n.left.accept(this) == "0" && n.right.accept(this) == "0")){
            System.out.println("trueor");
            return "0";
        }else if((n.left.accept(this) == "-1" && n.right.accept(this) == "-1")){
            System.out.println("falseor");

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
        //String str = " ( "+n.left.accept(this)+" && "+n.right.accept(this)+" ) ";
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
        lo.g("blocknode entering");
        ST.dive();
        lo.g("blocknode dived");
        lo.g("blocknode childs:"+n.children.size());
        for (ASTNode c: n.children){
            str += TAB.repeat(indent) + c.accept(this);
        }
        //When finished, climb back to parrent scope
        ST.climb();
        return str;
    }

    @Override
    public String visit(ParameterBlock n) {
        return null;
    }

    @Override
    public String visit(Assignment n) {
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
                    # assignemnt
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
    public String visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public String visit(ActionDefinitionNode n) {
        return null;
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
            str+= """
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
        System.out.println("strdecl");
        if(n.value == null){
            data+= """
                    .LC%d:
                        .string	""
                    """.formatted(temp);
            strTable.put(temp,"");
        }
        else if(((String)n.value.accept(this)).contains("DWORD")){
            System.out.println("1");
            data+= """
                    .LC%d:
                        .string	"%s"
                    """.formatted(temp,strTable.get(ptrTable.get(ST.retrieveSymbol(lastIdNode).hashCode())));
            System.out.println("3");
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
        lo.g("end cond"+condTable.get(n.ifBlock.hashCode()));
        LAmount++;
        int ifstmntLoc = LAmount;
        String str = """
                    \n
                    # Ifstatement start
                	mov eax, %s
                	cmp	eax, 0
                	jne	.L%d
                	# inner if s
                	%s
                	# inner if e
                	jmp	.L%d
                 .L%d:
                  # Ifstatement end
                """.formatted(n.predicate.accept(this),ifstmntLoc,n.ifBlock.accept(this),condTable.get(n.ifBlock.hashCode()),ifstmntLoc);
        lo.g("ifstmnt"+ifstmntLoc);
        LAmount++;
        lo.g("size"+n.elseifBlocks.size());
        if(n.elseifBlocks.size() >0) {
            for (ASTNode elseif : n.elseifBlocks) {
                lo.g(elseif);
                LAmount++;
                lo.g("elseif" + LAmount);
                str += """
                         #elasasd
                        	%s
                        	jmp	.L%d
                         .L%d:
                        """.formatted(elseif.accept(this), condTable.get(n.ifBlock.hashCode()), LAmount);
                LAmount++;
            }
        }
        lo.g("elseblock");

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
                 # elseif statement
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
                 # while loop start
                	jmp	.L%d
                .L%d:
                    # while loop block start
                	%s
                	# while loop block end
                .L%d:
                # predicate 
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
        //TODO: implement symbol table, implement all idnodes, implement the rest of the nodes. retrieve pointer loc.
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
            System.out.println(p.getClass().toString());
            if(printCount == n.prints.size()){
                EOL = "\\n";
            }
            if(p.getClass() == StringNode.class){
                //STRING
                System.out.println("2");
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
                    str += "    mov eax, DWORD PTR -%d[rbp]\n".formatted(ptrTable.get(symbol.hashCode()));
                    str += "    mov	esi, eax\n";
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
                                # bool print
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
        System.out.println(LAmount+" la print end");

        return str;
    }

    @Override
    public String visit(InputNode n) {
        System.out.println(LAmount+" la input start");
        dataAmount++;
        Symbol symbol = ST.retrieveSymbol(n.inputVariableName.name);
        String str = "";
        if(symbol.type instanceof IntType){
            data += """
                    .LC%d:
                    	.string	"%s"
                    """.formatted(dataAmount,"%d");
            str += """
                    # input
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
        System.out.println(LAmount+" la input");
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

    @Override
    public String visit(FieldAccessNode n) {
        return null;
    }
}
