package java112.labs1;


/**
 * @author Eric Knapp
 * class LabThree
 */
public class LabThree {

    private String firstName;


    /**
     * Run the demo
     */
    public void run(String input) {

        firstName = "Sue";
        System.out.println("input: " + firstName);
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
        String myArgument = "test";
        demo.firstName = "Bill";
        demo.run(myArgument);
        System.out.println("after: " + demo.firstName);
    }
}




