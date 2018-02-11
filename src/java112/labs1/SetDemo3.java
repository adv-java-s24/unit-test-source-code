package java112.labs1;

import java.util.*;

/**
 * @author Eric Knapp
 * class SetDemo3
 */
public class SetDemo3 {


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

        for (String nextValue : set) {
            System.out.println(nextValue);
        }



    }

    /**
     * The start of the program
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        SetDemo3 demo = new SetDemo3();
        demo.run();
    }

}





