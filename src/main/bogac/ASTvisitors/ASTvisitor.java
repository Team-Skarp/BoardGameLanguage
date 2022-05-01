package ASTvisitors;

import ASTnodes.*;

/**
 * This interface serves as the base visitor
 */
public interface ASTvisitor<T> {
    T visit(GameNode n);

    T visit(ArithmeticExpression n);
    T visit(PlusNode n);
    T visit(MinusNode n);
    T visit(UnaryMinusNode n);
    T visit(MultNode n);
    T visit(DivNode n);
    T visit(ModNode n);
    T visit(PowNode n);

    T visit(IdNode n);
    T visit(IntNode n);
    T visit(BooleanNode n);
    T visit(StringNode n);

    T visit(BooleanExpression n);
    T visit(EqualNode n);
    T visit(NotEqualNode n);
    T visit(LessThanNode n);
    T visit(GreaterThanNode n);
    T visit(GreaterThanEqualsNode n);
    T visit(LessThanEqualsNode n);
    T visit(NegationNode n);
    T visit(OrNode n);
    T visit(AndNode n);

    T visit(BlockNode n);
    T visit(Assignment n);

    //Definitions
    T visit(DesignDefinitionNode n);
    T visit(ActionDefinitionNode n);

    //Declarations
    T visit(Declaration n);
    T visit(ActionDeclarationNode n);
    T visit(DesignDeclarationNode n);
    T visit(SequentialDeclaration n);
    T visit(IntegerDeclarationNode n);
    T visit(IntegerAssignDeclarationNode n);
    T visit(BooleanDeclarationNode n);
    T visit(StringDeclarationNode n);
    T visit(PathDeclarationNode n);
    T visit(PathTypedDeclarationNode n);
    T visit(GridDeclarationNode n);
    T visit(GridTypedDeclarationNode n);

    //Conditionals
    T visit(ConditionalNode n);
    T visit(ElifConditionalNode n);
    T visit(ElseNode n);
    T visit(PredicateNode n);
    T visit(WhileNode n);
    T visit(ForeachNode n);

    //Misc
    T visit(PrintNode n);
    T visit(ActionCallNode n);
}
