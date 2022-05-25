package ASTvisitors;

import ASTnodes.*;
import Logging.Logger;

public class Evaluator implements ASTvisitor<Object> {
    Logger lo = new Logger();

    @Override
    public Object visit(GameNode n) {
        return null;
    }

    @Override
    public Object visit(Expression n) {
        return null;
    }

    @Override
    public Object visit(ArithmeticExpression n) {
        return null;
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
    public Object visit(UnaryMinusNode n) {
        return null;
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
    public Object visit(BlockNode n) {
        n.children.forEach(child -> child.accept(this)); //not working yet. gotta implement symbol table stuff
        return null;
    }

    @Override
    public Object visit(ParameterBlock n) {
        n.children.forEach(child -> child.accept(this));
        return null;
    }

    @Override
    public Object visit(NonScopeBlockNode n) {
        n.children.forEach(child -> child.accept(this));
        return null;
    }


    @Override
    public Object visit(Assignment n) {
        return null;
    }

    @Override
    public Object visit(AssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(StringAssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(IntegerAssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(BooleanAssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(DotAssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(ListIndexAssignmentNode n) {
        return null;
    }

    @Override
    public Object visit(DesignDefinitionNode n) {
        return null;
    }

    @Override
    public Object visit(ActionDefinitionNode n) {
        return null;
    }

    @Override
    public Object visit(Declaration n) {
        return null;
    }

    @Override
    public Object visit(ActionDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(DesignDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(ListDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(SequentialDeclaration n) {
        return null;
    }

    @Override
    public Object visit(StringNode n) {
        return null;
    }

    @Override
    public Object visit(BooleanExpression n) {
        return null;
    }

    @Override
    public Object visit(IntegerDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(BooleanDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(StringDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(PathDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(GridDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(GridTypedDeclarationNode n) {
        return null;
    }

    @Override
    public Object visit(ConditionalNode n) {
        lo.g(n.predicate+" "+n.ifBlock+" "+n.elseBlock);
        boolean predicate = (boolean) n.predicate.accept(this);
        Object ifBlock = n.ifBlock.accept(this);
        Object elseBlock = n.elseBlock.accept(this);
        if (predicate){
            return ifBlock;
        }else{
            return elseBlock;
        }
    }

    @Override
    public Object visit(ElifConditionalNode n) {
        return null;
    }

    @Override
    public Object visit(ElseNode n) {
        return null;
    }

    @Override
    public Object visit(PredicateNode n) {
        return null;
    }

    @Override
    public Object visit(WhileNode n) {
        return null;
    }

    @Override
    public Object visit(ForeachNode n) {
        return null;
    }

    @Override
    public Object visit(PrintNode n) {
        return null;
    }

    @Override
    public Object visit(InputNode n) {
        return null;
    }

    @Override
    public Object visit(ActionCallNode n) {
        return null;
    }

    @Override
    public Object visit(MethodCallNode n) {
        return null;
    }

    @Override
    public Object visit(ReturnNode n) {
        return null;
    }

    @Override
    public Object visit(FieldAccessNode n) {
        return null;
    }

    @Override
    public Object visit(FieldAccessLHNode n) {
        return null;
    }

    @Override
    public Object visit(ListElementNode n) {
        return null;
    }

    @Override
    public Object visit(ListNode n) {
        return null;
    }

    @Override
    public Object visit(IndexAccessNode n) {
        return null;
    }

    @Override
    public Object visit(ExitNode n) {
        return null;
    }

    @Override
    public Object visit(RandomNode n) {
        return null;
    }

    @Override
    public Object visit(SizeOfNode n) {
        return null;
    }

}
