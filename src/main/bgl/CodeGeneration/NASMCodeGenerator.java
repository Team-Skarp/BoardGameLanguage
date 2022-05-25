package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;
import Logging.Logger;

/**
 * Class for generating assembly x86 code
 * requires nasm: sudo apt-get install nasm
 * to compile and run the generated assembly code, save the code in a assembly.asm file, and run this on WSL:
 * "nasm -f elf64 -o out.o out.asm && ld out.o -o out && ./out"
 */

public class NASMCodeGenerator implements ASTvisitor<String> {
    Logger lo = new Logger();
    private final String EOL = ";\n";
    private final String indent = "    ";
    private int var_total = 0;

    String functions =      "\nquit:\n" +
                            "    mov       rax, 60                 ; system call for exit\n" +
                            "    xor       rdi, rdi                ; exit code 0\n" +
                            "    syscall                           ; invoke operating system to exit\n" +
                            "    ret\n" +
                            "    \n" +
                            "print:\n" +
                            "    mov       rax, 1                  ; system call for write\n" +
                            "    mov       rdi, 1                  ; file handle 1 is stdout\n" +
                            "    syscall\n" +
                            "    ret\n\n";

    String data =           "    call      quit\n" +
                            "\n" +
                            "section .data                         ; allocate data to memory\n";
    @Override
    public String visit(GameNode n) {
        String str =        "section .text                         ; flow of the program\n" +
                            "    global _start\n" +
                            "\n" +
                            "_start:\n"+n.setup.accept(this);
        return functions+str+data;
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
        return null;
    }

    @Override
    public String visit(MinusNode n) {
        return null;
    }

    @Override
    public String visit(UnaryMinusNode n) {
        return null;
    }

    @Override
    public String visit(MultNode n) {
        return null;
    }

    @Override
    public String visit(DivNode n) {
        return null;
    }

    @Override
    public String visit(ModNode n) {
        return null;
    }

    @Override
    public String visit(PowNode n) {
        return null;
    }

    @Override
    public String visit(IdNode n) {
        return null;
    }

    @Override
    public String visit(IntNode n) {
        String str = ""+n.value;;
        return str;
    }

    @Override
    public String visit(BooleanNode n) {
        return null;
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
        return null;
    }

    @Override
    public String visit(NotEqualNode n) {
        return null;
    }

    @Override
    public String visit(LessThanNode n) {
        return null;
    }

    @Override
    public String visit(GreaterThanNode n) {
        return null;
    }

    @Override
    public String visit(GreaterThanEqualsNode n) {
        return null;
    }

    @Override
    public String visit(LessThanEqualsNode n) {
        return null;
    }

    @Override
    public String visit(NegationNode n) {
        return null;
    }

    @Override
    public String visit(OrNode n) {
        return null;
    }

    @Override
    public String visit(AndNode n) {
        return null;
    }

    @Override
    public String visit(BlockNode n) {
        String str = "";
        for(ASTNode c : n.children){
            str+=c.accept(this)+"\n";
        }
        return str;
    }

    @Override
    public String visit(ParameterBlock n) {
        return null;
    }

    @Override
    public String visit(NonScopeBlockNode n) {
        return null;
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
    public String visit(DotAssignmentNode n) {
        return null;
    }

    @Override
    public String visit(ListIndexAssignmentNode n) {
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
        return null;
    }

    @Override
    public String visit(IntegerDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(BooleanDeclarationNode n) {
        return null;
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
        String str = "";
        String varName = "var"+var_total;
        String varLiteral = "";
        int bytesUsed = 1;
        for(ASTNode p : n.prints){
            if(p.getClass() == StringNode.class){
                //string literal
                bytesUsed += ((StringNode) p).value.length();
                varLiteral += "\""+((StringNode) p).value+"\",";
            }else if(p instanceof ArithmeticExpression ) {
                //arithmetic
                String numberStr = (String) p.accept(this);
                char[] nchar = numberStr.toCharArray();
                for(int i = 0; i < numberStr.length(); i++){
                    varLiteral+=((int)nchar[i])+",";
                }
                bytesUsed += numberStr.length();
            }
        }
        var_total++;
        str+=   "    mov       rsi, "+varName+"              ; address of string to output\n" +
                "    mov       rdx, "+bytesUsed+"                 ; number of bytes\n" +
                "    call      print                             ";
        data+=indent+varName+" db "+varLiteral+"10\n";
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
    public String visit(MethodCallNode n) {
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
