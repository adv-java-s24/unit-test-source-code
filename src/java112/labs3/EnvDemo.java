package java112.labs3;

/**
 * @author Eric Knapp
 * class EnvDemo
 */
public class EnvDemo {


    /**
     * Run the demo
     */
    public void run() {
        System.out.println(System.getProperty("java.io.tmpdir"));
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        EnvDemo demo = new EnvDemo();
        demo.run();
    }

}
