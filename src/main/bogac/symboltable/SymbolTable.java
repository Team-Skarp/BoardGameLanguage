package symboltable;

import symboltable.attributes.Attributes;

public class SymbolTable { //Is this a symbol table or a symbol tree with block nodes

    //Global block
    private Block activeBlock;

    public SymbolTable() {
        activeBlock = new Block();
        activeBlock.setParent(null);
    }

    public SymbolTable openScope() {

        System.out.println("Scope opened");
        Block child = new Block();
        activeBlock.addChild(child);
        child.setParent(activeBlock);

        activeBlock = child;    //Hand control to child block

        return this;
    }

    public SymbolTable closeScope() {
        System.out.println("Scope closed");
        activeBlock = activeBlock.getParent();

        return this;
    }

    /**
     * Retrieves a symbol from either the current scope or any of the parrent scopes.
     * @param name of the symbol
     * @return Symbol that is found
     */
    public Symbol retrieveSymbol(String name) {

        Symbol sym = activeBlock.getSymbolWith(name);

        if (sym == null) {  //If symbol is not found in current block-scope
            Block temp_block = activeBlock; //Remember current scope

            if (activeBlock.getParent() == null) {  //If no parent scope exists, symbol does not exist
                throw new ReferenceErrorException(String.format("name '%s' is not defined", name));
            }

            activeBlock = activeBlock.getParent();  //todo: consider whether it is a little bit hacky to set a symbol table's active block (own scope) to be its parent scope

            Symbol found_sym = retrieveSymbol(name); //Call recursively to find the symbol in the parent block

            activeBlock = temp_block;   //Set the active block back to be the temporary block

            return found_sym;
        }

        System.out.printf("Symbol retrieved: '%s' of type '%s' %n", name, sym.attrs.thisType());
        return sym;
    }

    /**
     * Enters a single Symbol into the current block
     * @param name of the symbol
     * @param attrs {@link Attributes} of the symbol
     */
    public SymbolTable enterSymbol(String name, Attributes attrs) {

        System.out.printf("Symbol entered: '%s' of type '%s'%n", name, attrs.thisType());

        activeBlock.addSymbol(new Symbol(name, attrs));

        return this;

    }

    /**
     * Check that a symbol is declared in the current scope
     * @param name of the symbol
     * @return boolean
     */
    public boolean declaredLocally(String name) {
        Symbol sym = activeBlock.getSymbolWith(name);
        if (sym != null) { // return sym != null;
            return true;
        }
        else {
            return false;
        }
    }

}
