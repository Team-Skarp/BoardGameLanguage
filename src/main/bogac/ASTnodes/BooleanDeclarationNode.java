package ASTnodes;

import ASTvisitors.ASTvisitor;

public class BooleanDeclarationNode implements ASTNode {
    public String typeChild;
    public String identifierChild;
    public String assignChild;
    public ASTNode booleanExpressionChild;

    public BooleanDeclarationNode(String typeChild, String identifierChild, String assignChild, ASTNode booleanExpressionChild) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
        this.assignChild = assignChild;
        this.booleanExpressionChild = booleanExpressionChild;
    }

    public BooleanDeclarationNode(String typeChild, String identifierChild) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return null;
    }
}
