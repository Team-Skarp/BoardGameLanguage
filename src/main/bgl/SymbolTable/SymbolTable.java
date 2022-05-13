package SymbolTable;

public class SymbolTable {

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
     * Retrieves a symbol from either the current scope or any of the parent scopes.
     * @param name of the symbol
     * @return Symbol that is found
     */
    public Symbol retrieveSymbol(String name) {

        Symbol sym = activeBlock.getSymbolWith(name);

        if (sym == null) {
            Block temp_block = activeBlock;

            if (activeBlock.getParent() == null) {
                throw new ReferenceErrorException(String.format("name '%s' is not defined", name));
            }

            activeBlock = activeBlock.getParent();

            Symbol found_sym = retrieveSymbol(name); //Call recursively to find the symbol in the parent block

            activeBlock = temp_block;   //Set the active block back to be the temporary block

            return found_sym;
        }

        System.out.printf("Symbol retrieved: '%s' of type '%s' %n", name, sym.type);
        return sym;
    }

    /**
     * Enters a single Symbol into the current block
     * @throws DuplicateSymbolException if symbol already exist
     */
    public SymbolTable enterSymbol(Symbol sym) {

        if (declaredLocally(sym.name)) {
            throw new DuplicateSymbolException("variable '%s' is already defined in current scope".formatted(sym.name));
        }
        activeBlock.addSymbol(sym);

        System.out.printf("Symbol entered: '%s' of type '%s'%n", sym.name, sym.type);

        return this;

    }

    /**
     * Sets the active block to be the first child in the list of blocks inside currently active block
     */
    public void dive() {
        if (activeBlock.getChildren().size() > 0) {
            System.out.printf("Dived into child %s%n", activeBlock.next);
            activeBlock = activeBlock.getChildren().get(activeBlock.next++); //Point to next child next time we dive in current scope
        }
    }

    /**
     * Sets the active block to be that of the parent block and pops itself
     *
     * Cannot climb if there is not parent scope to climb upto
     */
    public void climb() {
        if (activeBlock.getParent() != null) {
            activeBlock = activeBlock.getParent();
            System.out.println("Climbed to parent block");

            //Reset next counter so other visitors dives correctly into the first child scope
            activeBlock.next = 0;
        }
    }

    /**
     * Check that a symbol is declared in the current scope
     * @param name of the symbol
     * @return
     */
    private boolean declaredLocally(String name) {
        Symbol sym = activeBlock.getSymbolWith(name);
        if (sym != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public Block getActiveBlock() {
        return activeBlock;
    }


}
