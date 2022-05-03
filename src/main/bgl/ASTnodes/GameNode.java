package ASTnodes;

import ASTvisitors.ASTvisitor;

public class GameNode implements ASTNode {

    public ASTNode setup;
    public ASTNode rules;
    public ASTNode gameloop;

    public GameNode(ASTNode setup, ASTNode rules, ASTNode gameloop) {
        this.setup = setup;
        this.rules = rules;
        this.gameloop = gameloop;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
