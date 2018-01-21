package java112.labs1;

import java.util.*;
import java.io.*;

/**
 * @author Eric Knapp
 * class LabEight
 *
 */
public class LabEight {

    private Set<String> set;

    public void run(String outputFilePath) {

        set = new TreeSet<String>();

        set.add("one");
        set.add("one");
        set.add("two");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("four");
        set.add("four");
        set.add("five");
        set.add("five");

        writeSetToOutputFile(outputFilePath);

    }

    private void writeSetToOutputFile(String outputFilePath) {

        PrintWriter outWriter = null;

        try {

            outWriter = new PrintWriter(new BufferedWriter(
                    new FileWriter(outputFilePath)));

            for (String word : set) {
                outWriter.println(word);
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
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }

    public static void main(String[] arguments) {
        LabEight lab = new LabEight();

        if (arguments.length == 1) {
            lab.run(arguments[0]);
        } else {
            System.out.println("Please enter one argument on the command"
                    + " line, an output file name");
            return;
        }
    }
}
