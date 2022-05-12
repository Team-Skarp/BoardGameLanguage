package Demos;

public class AllDemo {

    /**
     * Runs all the demos from the Demos directory.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("\nRuns CGenerationDemo:");
        CGenerationDemo.main(args);

        System.out.println("\nRuns EvaluatorDemo:");
        EvaluatorDemo.main(args);

        System.out.println("\nRuns GNUASMGenerationDemo:\n");
        GNUASMGenerationDemo.main(args);

        System.out.println("\nRuns NASMGenerationDemo:\n");
        NASMGenerationDemo.main(args);

        System.out.println("\nRuns PrettyPrinterDemo:");
        PrettyPrinterDemo.main(args);
    }
}
