package ASTnodes;
import ASTvisitors.ASTvisitor;

public class IdNode implements ASTNode, ArithmeticExpression {

    public final String name;       //Name of the variable

    /**
     * Constructor used as a placeholder for a variable name
     */
    public IdNode(String name) {
        this.name = name;

    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
