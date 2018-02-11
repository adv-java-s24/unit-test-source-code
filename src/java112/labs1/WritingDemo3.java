package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class WritingDemo3
 */
public class WritingDemo3 {


    /**
     * Run the demo
     */
    public void run() {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new BufferedWriter(new FileWriter("output/output.txt")));

            writer.println("Hello!");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        WritingDemo3 demo = new WritingDemo3();
        demo.run();
    }

}
