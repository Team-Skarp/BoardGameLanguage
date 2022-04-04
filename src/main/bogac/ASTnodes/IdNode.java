package ASTnodes;
import ASTvisitors.ASTvisitor;
import antlr.BoardVisitor;

public class IdNode implements ASTNode {

    public final String value;
    public final String type;

    public IdNode(String value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void accept(ASTvisitor v) {
        v.visit(this);
    }
}