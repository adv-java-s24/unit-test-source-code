package java112.analyzer;


/**
 * @author Eric Knapp
 * class FileAnalysis
 */
public class FileAnalysis {

    private static final int VALID_ARGUMENT_COUNT = 1;


    /**
     * Constructor for FileAnalysis
     */
    public FileAnalysis() {
    }


    public void analyze(String[] arguments) {

        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please enter a file path.");
            return;
        }

        System.out.println("In FileAnalysis.analyze(): " + arguments[0]);
    }
}






