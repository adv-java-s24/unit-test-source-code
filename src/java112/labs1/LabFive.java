package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class LabFive
 * TODO: comment
 */
public class LabFive {


    public void run(String outputFilePath, String message) {

        PrintWriter outWriter = null;
        try {

            // outWriter = new PrintWriter(new BufferedWriter(
                    // new FileWriter(outputFilePath)));

            outWriter = new PrintWriter(outputFilePath);

            outWriter.println(message);
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            outWriter.close();
        }
    }

    public static void main(String[] arguments) {
        LabFive lab = new LabFive();

        if (arguments.length == 2) {
            lab.run(arguments[0], arguments[1]);
        } else {
            System.out.println("Please enter two arguments on the command"
                + " line, a file name and a message");
        }
    }

}
