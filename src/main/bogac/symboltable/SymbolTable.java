package symboltable;

public class SymbolTable {

    //Global block
    private Block activeBlock;

    public SymbolTable() {
        activeBlock = new Block();
        activeBlock.setParent(null);
    }

    public void openScope() {

        System.out.println("Scope opened");
        Block child = new Block();
        activeBlock.addChild(child);
        child.setParent(activeBlock);

        activeBlock = child;    //Hand control to child block
    }

    public void closeScope() {
        System.out.println("Scope closed");
        activeBlock = activeBlock.getParent();
    }

    /**
     * Retrieves a symbol from either the current scope or any of the parrent scopes.
     * @param name of the symbol
     * @return
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

        System.out.println("Symbol retrieved: " + sym.name + " " + sym.type);
        return sym;
    }

    /**
     * Enters a single Symbol into the current block
     * @param name of the symbol
     * @param type of the symbol
     */
    public void enterSymbol(String name, String type) {

        System.out.println("Symbol entered: " + type + " " + name);

        if (isAlreadyDeclaredWith(name)) {
            throw new DuplicateSymbolException(name + " is already declared in current scope");
        }

        activeBlock.addSymbol(new Symbol(name, type));

    }

    /**
     * Check that a symbol is declared in the current scope
     * @param name of the symbol
     * @return
     */
    private boolean isAlreadyDeclaredWith(String name) {
        Symbol sym = activeBlock.getSymbolWith(name);
        if (sym != null) {
            return true;
        }
        else {
            return false;
        }
    }

}
