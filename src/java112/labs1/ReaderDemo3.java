package java112.labs1;

import java.io.*;

/**
 * @author Eric Knapp
 * class ReaderDemo3
 */
public class ReaderDemo3 {

    private static final int VALID_ARGUMENTS_COUNT = 1;

    /**
     * Run the demo
     */
    public void run(String filePath) {

        BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader(filePath));

            while (input.ready()) {
                System.out.println(input.readLine());
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }

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
        ReaderDemo3 demo = new ReaderDemo3();
        demo.run(arguments[0]);
    }

}




