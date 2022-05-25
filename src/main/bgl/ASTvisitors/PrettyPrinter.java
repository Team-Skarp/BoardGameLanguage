package ASTvisitors;

import ASTnodes.*;
import Logging.Logger;

/**
 * Class for printing out an AST tree
 */
public class PrettyPrinter implements ASTvisitor<Void> {

    private int             indent = 0;
    private final String    TAB = "\t";
    Logger lo = new Logger();


    @Override
    public Void visit(GameNode n) {
        n.setup.accept(this);
        n.rules.accept(this);
        n.gameloop.accept(this);
        return null;
    }

    @Override
    public Void visit(Expression n) {
        n.accept(this);
        return null;
    }

    @Override
    public Void visit(ArithmeticExpression n) {
        n.accept(this);
        return null;
    }

    @Override
    public Void visit(PlusNode n) {

        System.out.println(TAB.repeat(indent) + "Plus");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(MinusNode n) {

        System.out.println(TAB.repeat(indent) + "Minus");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(UnaryMinusNode n) {

        System.out.print(TAB.repeat(indent) + "-");

        //to help pretty print unary negative more readable
        int tempIndent = indent;
        indent = 0;
        n.operand.accept(this);
        indent = tempIndent;

        return null;
    }

    @Override
    public Void visit(MultNode n) {
        System.out.println(TAB.repeat(indent) + "Mult");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(DivNode n) {

        System.out.println(TAB.repeat(indent) + "Div");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(ModNode n) {

        System.out.println(TAB.repeat(indent) + "Mod");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(PowNode n) {

        System.out.println(TAB.repeat(indent) + "Pow");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(IdNode n) {

        System.out.println(TAB.repeat(indent) + n.name);

        return null;
    }

    @Override
    public Void visit(IntNode n) {

        System.out.println(TAB.repeat(indent) + n.value);
        return null;
    }

    @Override
    public Void visit(EqualNode n) {
        System.out.println(TAB.repeat(indent) + "==");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(NotEqualNode n) {
        System.out.println(TAB.repeat(indent) + "!=");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(LessThanNode n) {

        System.out.println(TAB.repeat(indent) + "<");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(GreaterThanNode n) {

        System.out.println(TAB.repeat(indent) + ">");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(GreaterThanEqualsNode n) {

        System.out.println(TAB.repeat(indent) + ">=");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(LessThanEqualsNode n) {

        System.out.println(TAB.repeat(indent) + "<=");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(BooleanNode n) {

        System.out.println(TAB.repeat(indent) + n.value);

        return null;
    }

    @Override
    public Void visit(NegationNode n) {
        System.out.println(TAB.repeat(indent) + "!");

        indent++;

        n.child.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(OrNode n) {
        System.out.println(TAB.repeat(indent) + "or");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(AndNode n) {
        System.out.println(TAB.repeat(indent) + "and");

        indent++;

        n.left.accept(this);
        n.right.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(BlockNode n) {

        System.out.println(TAB.repeat(indent) + "{");

        indent++;

        for(ASTNode child: n.children){
            child.accept(this);
        }

        indent--;

        System.out.println(TAB.repeat(indent) + "}");

        return null;
    }

    @Override
    public Void visit(ParameterBlock n) {
        System.out.println(TAB.repeat(indent) + "{");

        indent++;

        for(ASTNode child: n.children){
            child.accept(this);
        }

        indent--;

        System.out.println(TAB.repeat(indent) + "}");
        return null;
    }

    @Override
    public Void visit(NonScopeBlockNode n) {
        System.out.println(TAB.repeat(indent) + "{");

        indent++;

        for(ASTNode child: n.children){
            child.accept(this);
        }

        indent--;

        System.out.println(TAB.repeat(indent) + "}");
        return null;
    }

    @Override
    public Void visit(Assignment n) {
        return null;
    }

    @Override
    public Void visit(AssignmentNode n) {
        return null;
    }

    @Override
    public Void visit(StringAssignmentNode n) {
        System.out.println(TAB.repeat(indent) + "String assign: ");

        indent++;

        n.getLeft().accept(this);
        n.getRight().accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(IntegerAssignmentNode n) {
        System.out.println(TAB.repeat(indent) + "Int assign: ");

        indent++;

        n.getLeft().accept(this);
        n.getRight().accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(BooleanAssignmentNode n) {
        System.out.println(TAB.repeat(indent) + "Bool assign: ");

        indent++;

        n.getLeft().accept(this);
        n.getRight().accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(DotAssignmentNode n) {
        System.out.println(TAB.repeat(indent) + "Dot assign: ");

        indent++;

        n.getLeft().accept(this);
        n.getRight().accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(ListIndexAssignmentNode n) {
        return null;
    }

    @Override
    public Void visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public Void visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public Void visit(Declaration n) {
        return null;
    }

    @Override
    public Void visit(ActionDeclarationNode n) {
        return null;
    }

    @Override
    public Void visit(DesignDeclarationNode n) {
        return null;
    }

    @Override
    public Void visit(ListDeclarationNode n) {

        if (n.assignedList != null && n.assignedList.elements != null) {
            for (ASTNode element : n.assignedList.elements) {
                element.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(SequentialDeclaration n) {

        System.out.println(TAB.repeat(indent) + "Sequential Declaration of: " + n.type);

        indent++;

        for (Declaration dcl : n.declarations) {
            dcl.accept(this);
        }

        indent--;

        return null;
    }

    @Override
    public Void visit(StringNode n) {

        System.out.println(TAB.repeat(indent)+"\""+n.value+"\"");

        return null;
    }

    @Override
    public Void visit(BooleanExpression n) {
        n.accept(this);
        return null;
    }

    @Override
    public Void visit(IntegerDeclarationNode n) {

        System.out.println(TAB.repeat(indent)+"type: " + n.type());
        System.out.println(TAB.repeat(indent)+"varName: " + n.name);

        indent++;

        if (n.value != null){
            n.value.accept(this);
        }

        indent--;

        return null;
    }

    @Override
    public Void visit(BooleanDeclarationNode n) {

        System.out.println(TAB.repeat(indent)+"type: " + n.type());
        System.out.println(TAB.repeat(indent)+"varName: " + n.name);

        indent++;

        if (n.value != null){
            n.value.accept(this);
        }

        indent--;

        return null;
    }


    @Override
    public Void visit(StringDeclarationNode n) {

        System.out.println(TAB.repeat(indent)+"type: " + n.type());
        System.out.println(TAB.repeat(indent)+"varName: " + n.name);

        indent++;

        if (n.value != null){
            n.value.accept(this);
        }

        indent--;

        return null;
    }

    @Override
    public Void visit(PathDeclarationNode n) {

        indent++;

        System.out.println(n.type() + " ");
        System.out.println(n.name + " ");
        System.out.println(n.direction + " ");
        System.out.println(n.length + " ");

        indent--;

        return null;
    }

    @Override
    public Void visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public Void visit(GridDeclarationNode n) {

        indent++;

        System.out.println("type:" + n.type());
        System.out.println("varName:" + n.name);
        System.out.println("x size:" + n.x_size);
        System.out.println("y size:" + n.y_size);

        indent--;

        return null;
    }

    @Override
    public Void visit(GridTypedDeclarationNode n) {
        return null;
    }

    @Override
    public Void visit(ConditionalNode n) {

        System.out.println(TAB.repeat(indent) + "if statement");

        indent++;

        n.predicate.accept(this);
        n.ifBlock.accept(this);

        if(n.elseifBlocks != null){
            n.elseifBlocks.forEach(block -> block.accept(this));
        }

        if(n.elseBlock != null){
            n.elseBlock.accept(this);
        }

        indent--;

        return null;
    }

    @Override
    public Void visit(ElifConditionalNode n) {

        System.out.println(TAB.repeat(indent) + "elif block");

        indent++;

        n.predicate.accept(this);
        n.ifBlock.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(ElseNode n) {

        System.out.println(TAB.repeat(indent) + "else block");

        indent++;

        n.elseBlock.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(PredicateNode n) {

        System.out.println(TAB.repeat(indent) + "predicate");

        indent++;

        n.value.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(WhileNode n) {

        System.out.println(TAB.repeat(indent) + "while");

        indent++;

        n.predicate.accept(this);
        n.whileBlock.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(ForeachNode n) {

        System.out.println(TAB.repeat(indent) + "foreach");

        indent++;

        n.iterator.accept(this);
        n.iterable.accept(this);
        n.body.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(PrintNode n) {

        System.out.println(TAB.repeat(indent) + "print");

        indent++;

        n.prints.forEach(print -> print.accept(this));

        indent--;

        return null;
    }

    @Override
    public Void visit(InputNode n) {

        System.out.println(TAB.repeat(indent) + "input: ");

        indent++;

        n.inputVariableName.accept(this);

        indent--;

        return null;
    }

    @Override
    public Void visit(ActionCallNode n) {
        return null;
    }

    @Override
    public Void visit(MethodCallNode n) {
        return null;
    }

    @Override
    public Void visit(ReturnNode n) {
        return null;
    }

    @Override
    public Void visit(FieldAccessNode n) {
        System.out.println(TAB.repeat(indent) + "Field Access");

        indent++;

        n.fields.forEach(System.out::println);

        indent--;

        return null;
    }

    @Override
    public Void visit(FieldAccessLHNode n) {
        return null;
    }

    @Override
    public Void visit(ListElementNode n) {
        System.out.println("such a pretty list element node");
        return null;
    }

    @Override
    public Void visit(ListNode n) {
        System.out.println("such a pretty list node");
        return null;
    }

    @Override
    public Void visit(IndexAccessNode n) {
        return null;
    }

    @Override
    public Void visit(ExitNode n) {
        System.out.println("such a pretty exit node");
        return null;
    }

    @Override
    public Void visit(RandomNode n) {
        return null;
    }

    @Override
    public Void visit(SizeOfNode n) {
        return null;
    }

}
