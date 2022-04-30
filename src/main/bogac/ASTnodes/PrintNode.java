package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.List;

public class PrintNode implements ASTNode {
    public List<ASTNode> prints;


    public PrintNode(List<ASTNode> prints) {
        this.prints = prints;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
