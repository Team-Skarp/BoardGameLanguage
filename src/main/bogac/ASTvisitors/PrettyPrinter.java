package ASTvisitors;

import ASTnodes.*;

/**
 * Class for printing out an AST tree
 */
public class PrettyPrinter implements ASTvisitor<Void> {

    private int             indent = 0;
    private final String    TAB = "\t";

    @Override
    public Void visit(AssignNode n) {
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

        System.out.println(TAB.repeat(indent) + n.value);

        return null;
    }

    @Override
    public Void visit(IntNode n) {

        System.out.println(TAB.repeat(indent) + String.valueOf(n.value));
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

    @Override
    public Void visit(ArithmeticNode n) {
        return null;
    }

    @Override
    public Void visit(IntegerDeclarationNode n) {
        System.out.println(TAB.repeat(indent));
        indent++;
        System.out.print(n.typeChild+" ");
        System.out.print(n.identifierChild+" ");
        System.out.println(n.assignChild);
        n.arithmeticExpressionChild.accept(this);
        indent--;
        return null;
    }

    @Override
    public Void visit(IntegerAssignDeclarationNode n) {
        return null;
    }
    
    @Override
    public Void visit(BooleanDeclarationNode n) {
         indent++;
         System.out.print(n.typeChild+" ");
         System.out.print(n.identifierChild+" ");
         System.out.println(n.assignChild);
         n.booleanExpressionChild.accept(this);
         indent--;
        return null;
    }


    @Override
    public Void visit(StringDeclarationNode n) {
        indent++;

        System.out.println(n.typeChild + " ");
        System.out.println(n.identifierChild + " ");
        System.out.println(n.assignChild + " ");
        System.out.println(n.stringChild);

        indent--;

        return null;
    }

}
