package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class WritingDemo2
 */
public class WritingDemo2 {

    private static final int VALID_ARGUMENTS_COUNT = 2;

    /**
     * Run the demo
     */
    public void run(String filePath, String message) {


        try (
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))
        ) {

            writer.println("Hello, " + message + ". Writing from a PrintWriter!");

        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {

        if (arguments.length != VALID_ARGUMENTS_COUNT) {
            System.out.println("Nag");
            return;
        }

        WritingDemo2 demo = new WritingDemo2();
        demo.run(arguments[0], arguments[1]);
    }

}







