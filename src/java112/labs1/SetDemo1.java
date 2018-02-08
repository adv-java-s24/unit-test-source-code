package java112.labs1;

import java.util.*;

/**
 * @author Eric Knapp
 * class SetDemo1
 */
public class SetDemo1 {


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


        System.out.println(set);

        System.out.println();

        for (String nextValue : set) {
            System.out.println(nextValue);
        }



    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        SetDemo1 demo = new SetDemo1();
        demo.run();
    }

}
