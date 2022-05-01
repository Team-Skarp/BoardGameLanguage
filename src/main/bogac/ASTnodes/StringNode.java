package ASTnodes;

import ASTvisitors.ASTvisitor;

public class StringNode implements ASTNode, Expression {

    public String value;

    public StringNode(String value) {

        System.out.println("hej hans" + value);
        this.value = value.substring(1,value.length()-1); //todo: hvad sker der her?
    }

    @Override
    public Object accept(ASTvisitor v) {
        return v.visit(this);
    }
}
