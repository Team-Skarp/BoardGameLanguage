package ASTvisitors;

import ASTnodes.*;

public class Evaluator implements ASTvisitor<Object> {

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
    public Boolean visit(EqualNode n) {
        Object l_result = n.left.accept(this);
        Object r_result = n.right.accept(this);
        return l_result == r_result;
    }

    @Override
    public Boolean visit(NotEqualNode n) {
        Object l_result = n.left.accept(this);
        Object r_result = n.right.accept(this);
        return l_result != r_result;
    }

    @Override
    public Boolean visit(LessThanNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);
        return l_result < r_result;
    }

    @Override
    public Boolean visit(GreaterThanNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);
        return l_result > r_result;
    }

    @Override
    public Boolean visit(GreaterThanEqualsNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);
        return l_result >= r_result;
    }

    @Override
    public Boolean visit(LessThanEqualsNode n) {
        int l_result = (int) n.left.accept(this);
        int r_result = (int) n.right.accept(this);
        return l_result <= r_result;
    }

    @Override
    public Boolean visit(BooleanNode n) {
        return n.value;
    }

    @Override
    public Boolean visit(NegationNode n) {
        boolean result = (boolean) n.child.accept(this);
        return !result;
    }

    @Override
    public Boolean visit(OrNode n) {
        boolean l_result = (boolean) n.left.accept(this);
        boolean r_result = (boolean) n.right.accept(this);
        return l_result || r_result;
    }

    @Override
    public Boolean visit(AndNode n) {
        boolean l_result = (boolean) n.left.accept(this);
        boolean r_result = (boolean) n.right.accept(this);
        return l_result && r_result;
    }

    @Override
    public Object visit(ArithmeticNode n) {
        return null;
    }

    @Override //TODO: actually make the integer get saved in a variable, symbol table?
    public Object visit(IntDeclarationNode n) {
        int expr = (int) n.arithmeticExpressionChild.accept(this);
        return expr;
    }

    @Override
    public Object visit(BooleanDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(StringDeclarationNode n) {
        return null;
    }

}
