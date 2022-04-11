package ASTvisitors;

import ASTnodes.*;
import symboltable.SymbolTable;


public class SymbolHarvester implements ASTvisitor<SymbolTable> {

    SymbolTable sb;

    public SymbolHarvester() {
        this.sb = new SymbolTable();
    }

    @Override
    public SymbolTable visit(AssignNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PlusNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(MinusNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(MultNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(DivNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(ModNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PowNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(IdNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(IntNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(EqualNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(NotEqualNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(LessThanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterThanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GreaterThanEqualsNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(LessThanEqualsNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BooleanNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(NegationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(OrNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(AndNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BlockNode n) {
        sb.openScope();

        //Visit all children of block node
        for (ASTNode node : n.children) {

            node.accept(this);
        }

        sb.closeScope();

        return sb;
    }

    @Override
    public SymbolTable visit(IntegerDeclarationNode n) {

        sb.enterSymbol(n.id.value, n.id.type);
        return sb;
    }

    @Override
    public SymbolTable visit(IntegerAssignDeclarationNode n) {

        sb.enterSymbol(n.id.value, n.id.type);
        return sb;
    }

    @Override
    public SymbolTable visit(ArithmeticNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BooleanDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(StringDeclarationNode n) {
        return null;
    }
}
