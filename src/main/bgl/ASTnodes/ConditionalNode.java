package ASTnodes;

import ASTvisitors.ASTvisitor;

import java.util.ArrayList;
import java.util.List;

public class ConditionalNode implements ASTNode {
    public ASTNode predicate;
    public ASTNode ifBlock;
    public List<ASTNode> elseifBlocks;
    public ASTNode elseBlock;

    //if(){}
    public ConditionalNode(ASTNode boolExpr, ASTNode ifBlock) {
        this.predicate = boolExpr;
        this.ifBlock = ifBlock;
        this.elseifBlocks = null;
        this.elseBlock = null;
    }
    //if(){}else{}
    public ConditionalNode(ASTNode boolExpr, ASTNode ifBlock, ASTNode elseBlock) {
        this.predicate = boolExpr;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
        this.elseifBlocks = null;
    }
    //if(){}elseif(){}
    public ConditionalNode(ASTNode boolExpr,ASTNode ifBlock,List<ASTNode> elseifBlocks) {
        this.predicate = boolExpr;
        this.ifBlock = ifBlock;
        this.elseifBlocks = elseifBlocks;
        this.elseBlock = null;
    }
    //if(){}elseif(){}else{}
    public ConditionalNode(ASTNode boolExpr,ASTNode ifBlock,List<ASTNode> elseifBlocks, ASTNode elseBlock) {
        this.predicate = boolExpr;
        this.ifBlock = ifBlock;
        this.elseifBlocks = elseifBlocks;
        this.elseBlock = elseBlock;
    }


    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
