package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class LabSix
 * TODO: comment
 */
public class LabSix {


    public void run(String inputFilePath, String outputFilePath) {

        BufferedReader inputReader = null;
        PrintWriter outWriter = null;
        String line = null;
        try {

            inputReader = new BufferedReader(new FileReader(inputFilePath));
            outWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFilePath)));

            while (inputReader.ready()) {
                line = inputReader.readLine();
                outWriter.println(line);
            }

        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (outWriter != null) {
                    outWriter.close();
                }

                if (inputReader != null) {
                    inputReader.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }

    public static void main(String[] arguments) {
        LabSix lab = new LabSix();

        if (arguments.length == 2) {
            lab.run(arguments[0], arguments[1]);
        } else {
            System.out.println("Please enter two arguments on the command"
                    + " line, an input file name and an output file name");
            return;
        }
    }

}
