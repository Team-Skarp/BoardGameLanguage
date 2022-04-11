package ASTnodes;
import ASTvisitors.ASTvisitor;

public class IntDeclarationNode implements ASTNode {
    public String typeChild;
    public String identifierChild;
    public String assignChild;
    public ASTNode arithmeticExpressionChild;

    public IntDeclarationNode(String typeChild, String identifierChild, String assignChild, ASTNode arithmeticExpressionChild) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
        this.assignChild = assignChild;
        this.arithmeticExpressionChild = arithmeticExpressionChild;
    }

    public IntDeclarationNode(String typeChild, String identifierChild) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
