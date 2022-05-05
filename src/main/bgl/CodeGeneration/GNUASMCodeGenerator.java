package CodeGeneration;

import ASTnodes.*;
import ASTvisitors.ASTvisitor;

public class GNUASMCodeGenerator implements ASTvisitor<String> {
    @Override
    public String visit(GameNode n) {
        String str = "";
        return str;
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
        return null;
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
        return null;
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
    public String visit(SequentialDeclaration n) {
        return null;
    }

    @Override
    public String visit(IntegerDeclarationNode n) {
        return null;
    }

    @Override
    public String visit(IntegerAssignDeclarationNode n) {
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
