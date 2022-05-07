package ASTnodes;

import ASTvisitors.ASTvisitor;
import SymbolTable.Symbol;

import java.util.List;

/**
 * Use this class when symbols need to be passed down into the block from an outer block
 */
public class ParameterBlock extends BlockNode implements ASTNode  {

    public List<Symbol> variables;     //Variables to be passed down into the body of the block

    public ParameterBlock(ASTNode... children) {
        super(children);
        this.variables = null;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
