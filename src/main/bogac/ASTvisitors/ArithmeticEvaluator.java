package ASTvisitors;

import ASTnodes.*;

public class ArithmeticEvaluator implements ASTvisitor<Integer> {

    @Override
    public Integer visit(AssignNode n) {
        return 0;
    }

    @Override
    public Integer visit(PlusNode n) {

        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return l_result + r_result;
    }

    @Override
    public Integer visit(MinusNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return l_result - r_result;
    }

    @Override
    public Integer visit(MultNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return l_result * r_result;
    }

    @Override
    public Integer visit(DivNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return l_result / r_result;
    }

    @Override
    public Integer visit(ModNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return l_result % r_result;
    }

    @Override
    public Integer visit(PowNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);

        return (int) Math.pow(l_result, r_result);
    }

    @Override
    public Integer visit(IdNode n) {
        return 99;                  //Look up the value in the symbol table!
    }

    @Override
    public Integer visit(IntNode n) {
        return n.value;
    }

    @Override
    public Integer visit(EqualNode n) {
        return null;
    }

    @Override
    public Integer visit(NotEqualNode n) {
        return null;
    }

    @Override
    public Integer visit(LessThanNode n) {
        return null;
    }

    @Override
    public Integer visit(GreaterThanNode n) {
        return null;
    }

    @Override
    public Integer visit(GreaterThanEqualsNode n) {
        return null;
    }

    @Override
    public Integer visit(LessThanEqualsNode n) {
        return null;
    }

    @Override
    public Integer visit(BooleanNode n) {
        return null;
    }

    @Override
    public Integer visit(NegationNode n) {
        return null;
    }

    @Override
    public Integer visit(OrNode n) {
        return null;
    }

    @Override
    public Integer visit(AndNode n) {
        return null;
    }


}
