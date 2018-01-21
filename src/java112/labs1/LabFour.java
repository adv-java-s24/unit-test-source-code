package java112.labs1;


import java.io.*;

/**
 * This is the class javadoc
 *
 * @author YOUR NAME HERE
 * @version 1.0
 */
public class LabFour {

    /**
     * The run method is where it all starts.
     */
    public void run(String input) {

        BufferedReader inputReader = null;
        try {
            inputReader = new BufferedReader(new FileReader(input));

            while (inputReader.ready()) {
                System.out.println(inputReader.readLine());
                //System.out.println(inputReader.readLine());
            }

        } catch (java.io.FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                inputReader.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }


    }

    /**
     * This is the main method
     * This is cool
     */
    public static void main(String[] arguments) {

        LabFour lab = new LabFour();

        if (arguments.length == 1) {
            lab.run(arguments[0]);
        } else {
            System.out.println("Please enter one argument on the command line");
        }
    }
}









