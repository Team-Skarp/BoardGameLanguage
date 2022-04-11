package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringDeclarationNode implements ASTNode {
    public String typeChild;
    public String identifierChild;
    public String assignChild;
    public String stringChild;

    // Handle string declaration and assignment: str stringVar = "Hello";
    public StringDeclarationNode(
            String typeChild,
            String identifierChild,
            String assignChild,
            String stringChild
    ) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
        this.assignChild = assignChild;
        this.stringChild = stringChild;
    }

    // Handle string declaration. ex: str stringVar;
    public StringDeclarationNode(
            String typeChild,
            String identifierChild
    ) {
        this.typeChild = typeChild;
        this.identifierChild = identifierChild;
    }

    @Override
    public Object accept(ASTvisitor v) { return null; }
}
