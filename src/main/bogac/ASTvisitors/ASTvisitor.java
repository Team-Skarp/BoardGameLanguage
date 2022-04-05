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
}
