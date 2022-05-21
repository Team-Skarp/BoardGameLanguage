package ASTnodes;
import ASTvisitors.ASTvisitor;

public class IdNode implements ArithmeticExpression, Accessable, ASTNode {

    public final String name;       //Name of the variable
    public int value;

    /**
     * Constructor used as a placeholder for a variable name
     */
    public IdNode(String name) {
        this.name = name;
    }

    /**
     * Special constructor used when variable has value set by assignment
     */
    public IdNode(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }

    @Override
    public String getAccessName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
