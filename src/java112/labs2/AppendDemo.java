package java112.labs2;

import java.io.*;

/**
 * @author Eric Knapp
 * class AppendDemo
 */
public class AppendDemo {


    /**
     * Run the demo
     */
    public void run() {


        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("append-out.txt", true)))) {

            out.println("My output");
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
        AppendDemo demo = new AppendDemo();
        demo.run();
    }

}
