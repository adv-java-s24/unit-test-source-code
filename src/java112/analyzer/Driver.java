package java112.analyzer;

/**

 * @author Eric Knapp
 * class Driver
 */
public class Driver {

    /**
     * TODO: comment
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        FileAnalysis analyzer = new FileAnalysis();
        analyzer.analyze(arguments);
    }

}