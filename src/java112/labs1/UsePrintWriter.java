package java112.labs1;


import java.io.*;


/**
 *  This class demonstrates the use of the PrintWriter class for writing to
 *  files. It takes two arguments from the command line. The first argument is
 *  the name of the output file. The second argument is a first name.
 *
 *@author    eknapp
 */
public class UsePrintWriter {

    private static final int VALID_ARGUMENT_COUNT = 2;


    /**
     * Basic constructor for UsePrintWriter
     */
    public UsePrintWriter() {
    }


    /**
     *  Main processing method for the UsePrintWriter object.
     * @param arguments The command line arguments
     */
    public void run(String[] arguments) {

        if (arguments.length != VALID_ARGUMENT_COUNT) {
            System.out.println("Please add a file name and a first name.");
            return;
        }


        String fileName = arguments[0];
        String firstName = arguments[1];

        openOutputFile(fileName, firstName);
    }


    /**
     * Open a PrintWriter to the specified file name.
     * @param fileName the file to create and write
     * @param firstName the name to say hello
     */
    public void openOutputFile(String fileName, String firstName) {

        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

            writeGreeting(output, firstName);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }


    /**
     * Write the greeting to the user in the output file.
     * @param writer the PrintWriter open to the new file
     * @param firstName the entered first name to greet
     */
    public void writeGreeting(PrintWriter writer, String firstName) {
        writer.print("Hello, ");
        writer.print(firstName);
        writer.println(".");
        writer.println("How's it going?");
    }


    /**
     *  The main program for the UsePrintWriter class.
     *
     *@param  arguments The command line arguments
     *
     */
    public static void main(String[] arguments) {

        UsePrintWriter demo = new UsePrintWriter();
        demo.run(arguments);
    }
}
