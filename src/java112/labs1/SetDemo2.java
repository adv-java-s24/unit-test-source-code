package java112.labs1;

import java.util.*;

/**
 * @author Eric Knapp
 * class SetDemo2
 */
public class SetDemo2 {


    /**
     * Run the demo
     */
    public void run() {
        Set<String> set = new TreeSet<>();

        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        set.add("Five");
        set.add("Four");
        set.add("Four");

        System.out.println();
        System.out.println(set);
        System.out.println();
    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        SetDemo2 demo = new SetDemo2();
        demo.run();
    }

}







