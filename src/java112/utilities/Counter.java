package java112.utilities;


/**
 * @author Eric Knapp
 * class Counter
 */
public class Counter {

    private int count;


    /**
     * Constructor for Counter
     */
    public Counter() {
        count = 1;
    }


    /**
     *
     */
    public void increment() {
        count += 1;
    }


    public int getCount() {
        return count;
    }


    public String toString() {
        String countString = count + "";
        return countString;
    }
}

