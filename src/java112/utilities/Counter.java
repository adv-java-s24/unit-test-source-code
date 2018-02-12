package java112.utilities;

/**
 * @author Eric Knapp
 * class Counter
 */
public class Counter implements Comparable {

    private int count;

    /**
     * Constructor for Counter
     */
    public Counter() {
        count = 1;
    }

    /**
     * TODO: comment
     */
    public void increment() {
        count += 1;
    }

    /**
     * TODO: comment
     */
    public int getCount() {
        return count;
    }

    /**
     * TODO: comment
     */
    public int compareTo(Object counter) throws NullPointerException, ClassCastException {

        Counter secondCounter = (Counter)counter;

        int returnValue = 0;

        if (this.count == secondCounter.getCount()) {
            returnValue =  0;
        } else if (this.count < secondCounter.getCount()) {
            returnValue = -1;
        } else if (this.count > secondCounter.getCount()) {
            returnValue = 1;
        }

        return returnValue;
    }

    public String toString() {
        String countString = count + "";
        return countString;
    }

}