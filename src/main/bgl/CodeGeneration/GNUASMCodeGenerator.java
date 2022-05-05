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
        lo.g(data);
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
        String str = ""; //TODO: figure out how to integrate a power function. use loop to increment?
        return str;
    }
    @Override
    public String visit(IdNode n) {
        return null;
    }

    @Override
    public String visit(IntNode n) {
        String str = n.value+"";
        return str;
    }

    @Override
    public String visit(BooleanNode n) {
        if(n.value == true){
            return "1";
        }else{
            return "0";
        }
    }

    @Override
    public String visit(StringNode n) {
        return null;
    }

    @Override
    public String visit(BooleanExpression n) {
        return null;
    }

    @Override
    public String visit(EqualNode n) {
        String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "(!("+a+">"+b+")&&!("+a+"<"+b+"))";
        return str;
    }

    @Override
    public String visit(NotEqualNode n) {
        String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "(("+a+">"+b+")||("+a+"<"+b+"))";
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
        String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "((!("+a+">"+b+")&&!("+a+"<"+b+"))||("+a+">"+b+"))";
        return str;
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        String a = n.left.accept(this)+"";
        String b = n.right.accept(this)+"";
        String str = "((!("+a+">"+b+")&&!("+a+"<"+b+"))||("+a+"<"+b+"))";
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
        String str = "\n";
        List<Block> childBlocks = ST.getActiveBlock().getChildren();

        if (childBlocks.size() > 0) {
            int cnt = 0;
            for (Block block : childBlocks) {
                ST.dive();
                String dataCpy = data;
                String strCpy = str;
                int dataAmountCpy = dataAmount;
                int pointerOffsetCpy = pointerOffset;
                int LAmountCpy = LAmount;
                HashMap<Integer,Integer> ptrTableCpy = ptrTable;

                cnt++;
                for (ASTNode c: n.children){

                    str += (String) c.accept(this);
                }
                if(cnt != 2){
                    data = dataCpy;
                    str = strCpy;
                    pointerOffset = pointerOffsetCpy;
                    dataAmount = dataAmountCpy;
                    ptrTable = ptrTableCpy;
                    LAmount = LAmountCpy;
                }
            }
        } else {
            for (ASTNode c: n.children){
                str += (String) c.accept(this);
            }
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
        int ptr = pointerOffset-16;
        String str = """
                    mov	DWORD PTR -%d[rbp], %s
                """.formatted(ptr,n.value.accept(this));
        Symbol symbol = ST.retrieveSymbol(n.name);
        lo.g(symbol.hashCode());
        ptrTable.put(symbol.hashCode(),ptr);
        return str;
    }

    @Override
    public String visit(IntegerAssignDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(BooleanDeclarationNode n) {
        pointerOffset += 1;
        int ptr = pointerOffset-16;
        String str = """
                    mov	BYTE PTR -%d[rbp], %s
                """.formatted(ptr,n.value.accept(this));
        Symbol symbol = ST.retrieveSymbol(n.name);
        lo.g(symbol.hashCode());
        ptrTable.put(symbol.hashCode(),ptr);
        return str;
    }

    @Override
    public String visit(StringDeclarationNode n) {
        return null;
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
        return null;
    }

    @Override
    public String visit(ElifConditionalNode n) {
        return null;
    }

    @Override
    public String visit(ElseNode n) {
        return null;
    }

    @Override
    public String visit(PredicateNode n) {
        return null;
    }

    @Override
    public String visit(WhileNode n) {
        return null;
    }

    @Override
    public String visit(ForeachNode n) {
        return null;
    }

    @Override
    public String visit(PrintNode n) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        lo.g(stackTraceElements);
        //TODO: implement symbol table, implement all idnodes, implement the rest of the nodes. retrieve pointer loc.
        printNode = n;
        String str = "";
        String EOL = "";
        int printCount = 1;
        for (ASTNode p : n.prints){
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
                Symbol symbol = ST.retrieveSymbol(((IdNode) p).name);
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
                        	cmp	BYTE PTR -%d[rbp], 0	
                        	je	.L%d
                        	lea	rax, .LC0[rip]
                        	jmp	.L%d
                        .L%d:
                        	lea	rax, .LC1[rip]
                        .L%d:
                            mov rsi, rax
                        """.formatted(ptrTable.get(symbol.hashCode()),LAmount,LAmount+1,LAmount,LAmount+1);
                    LAmount+=2;
                }
            }else if(p.getClass() == BooleanNode.class){
                //Boolean

            }
            str +="""
                    \n
                    lea	rdi, .LC%d[rip]
                	mov	eax, 0
                	call	printf@PLT
                """.formatted(dataAmount);
            dataAmount++;
            printCount++;
        }
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
