package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringNode implements ASTNode, Expression {

    public String value;

    public StringNode(String value) {
        value = value.substring(1,value.length()-1); //todo Hvorfor bliver der fjernet det første og det sidste bogstav i et navn, som man har angivet?
        this.value = value;
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
