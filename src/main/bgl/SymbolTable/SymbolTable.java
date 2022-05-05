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
     * Retrieves a symbol from either the current scope or any of the parrent scopes.
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

            Symbol found_sym = retrieveSymbol(name); //Call recursively to find the symbol in the parrent block

            activeBlock = temp_block;   //Set the active block back to be the temporary block

            return found_sym;
        }

        System.out.println(String.format("Symbol retrieved: '%s' of type '%s' ", name, sym.type));
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

        System.out.println(String.format("Symbol entered: '%s' of type '%s'", sym.name, sym.type));

        return this;

    }

    /**
     * Sets the active block to be the first child in the list of blocks inside currently active block
     */
    public void dive() {
        if (activeBlock.getChildren().size() != 0)
            this.activeBlock = this.activeBlock.getChildren().get(0);
    }

    /**
     * Sets the active block to be that of the parrent block and pops itself
     *
     * Cannot climb if there is not parrent scope to climb into
     */
    public void climb() {
        if (activeBlock.getParent() != null) {
            Block oldBlock = activeBlock;
            activeBlock = activeBlock.getParent();
            activeBlock.getChildren().remove(oldBlock);
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
