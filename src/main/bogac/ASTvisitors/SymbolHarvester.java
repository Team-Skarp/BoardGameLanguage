package ASTvisitors;

import ASTnodes.*;
import symboltable.DuplicateSymbolException;
import symboltable.SymbolTable;
import symboltable.attributes.PrimitiveAttributes;
import symboltable.types.IntType;


public class SymbolHarvester implements ASTvisitor<SymbolTable> {

    SymbolTable ST;

    public SymbolHarvester() {
        this.ST = new SymbolTable();
    }

    @Override
    public SymbolTable visit(ArithmeticExpression n) {
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
        ST.openScope();

        //Visit all children of block node
        for (ASTNode node : n.children) {

            node.accept(this);
        }

        ST.closeScope();

        return ST;
    }

    @Override
    public SymbolTable visit(Assignment n) {
        return visit(n);
    }

    @Override
    public SymbolTable visit(StringNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(BooleanExpression n) {
        return null;
    }

    @Override
    public SymbolTable visit(IntegerDeclarationNode n) {

        IdNode identifier = n.id;

        PrimitiveAttributes attrs = new PrimitiveAttributes(new IntType());

        identifier.attrs = attrs;

        if (ST.declaredLocally(identifier.name)) {
            throw new DuplicateSymbolException(identifier.name + " is already declared in current scope");
        }

        ST.enterSymbol(identifier.name, attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(IntegerAssignDeclarationNode n) {

        IdNode identifier = n.id;
        PrimitiveAttributes attrs = new PrimitiveAttributes(new IntType());

        identifier.attrs = attrs;

        if (ST.declaredLocally(identifier.name)) {
            throw new DuplicateSymbolException(identifier.name + " is already declared in current scope");
        }

        ST.enterSymbol(identifier.name, attrs);
        return ST;
    }

    @Override
    public SymbolTable visit(BooleanDeclarationNode n) {
        sb.enterSymbol(n.id.value,n.id.type);
        return sb;
    }

    @Override
    public SymbolTable visit(StringDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(PathDeclarationNode n) {
        sb.enterSymbol(n.id.value, n.id.type);
        return sb;
    }

    @Override
    public SymbolTable visit(PathTypedDeclarationNode n) {
        return null;
    }

    @Override
    public SymbolTable visit(GridDeclarationNode n) {
        sb.enterSymbol(n.id.value, n.id.type);
        return sb;
    }

    @Override
    public SymbolTable visit(GridTypedDeclarationNode n) {
        return null;
    }
}
