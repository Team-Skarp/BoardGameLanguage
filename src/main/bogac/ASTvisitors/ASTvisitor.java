package ASTvisitors;

import ASTnodes.*;

/**
 * This interface serves as the base visitor
 */
public interface ASTvisitor<T> {

    T visit(AssignNode n);
    T visit(PlusNode n);
    T visit(MinusNode n);
    T visit(MultNode n);
    T visit(DivNode n);
    T visit(ModNode n);
    T visit(PowNode n);
    T visit(IdNode n);
    T visit(IntNode n);
    T visit(EqualNode n);
    T visit(NotEqualNode n);
    T visit(LessThanNode n);
    T visit(GreaterThanNode n);
    T visit(GreaterThanEqualsNode n);
    T visit(LessThanEqualsNode n);
    T visit(BooleanNode n);
    T visit(NegationNode n);
    T visit(OrNode n);
    T visit(AndNode n);
    T visit(ArithmeticNode n);
    T visit(IntDeclarationNode n);
}
