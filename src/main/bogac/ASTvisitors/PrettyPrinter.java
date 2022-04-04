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
}
