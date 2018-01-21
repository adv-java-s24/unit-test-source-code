package java112.labs1;

/**
 * @author Eric Knapp
 * class LabThree
 */
public class LabThree {


    /**
     * Run the demo
     */
    public void run(String input) {
        System.out.println("input: " + input);
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {

        if (arguments.length != 1) {
            System.out.println("Please enter one argument on the command line");
            return;
        }

        LabThree demo = new LabThree();
        demo.run(arguments[0]);
    }

}
