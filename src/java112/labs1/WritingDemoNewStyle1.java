package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class WritingDemoNewStyle1
 */
public class WritingDemoNewStyle1 {

    private static final int VALID_ARGUMENT_COUNT = 2;

    /**
     * Run the demo
     */
    public void run(String filePath, String message) {

        try (
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)))
        ) {

            writer.println(message);

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

        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Nag");
            return;
        }

        WritingDemoNewStyle1 demo = new WritingDemoNewStyle1();
        demo.run(arguments[0], arguments[1]);
    }

}





