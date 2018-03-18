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
     *
     */
    public void increment() {
        count += 1;
    }


    public int getCount() {
        return count;
    }

    public boolean equals(Object counter) {
        if (counter == null) {
            return false;
        }

        Counter secondCounter = (Counter)counter;

        if (this.count == secondCounter.getCount()) {
            return true;
        } else {
            return false;
        }
    }


    public int compareTo(Object counter) throws NullPointerException, ClassCastException {

        if (counter == null) {
            throw new NullPointerException();
        }

        Counter secondCounter = (Counter)counter;

        if (this.count == secondCounter.getCount()) {
            return 0;
        } else if (this.count < secondCounter.getCount()) {
            return -1;
        } else if (this.count > secondCounter.getCount()) {
            return 1;
        } else {
            return 1;
        }
    }


    public String toString() {
        String countString = count + "";
        return countString;
    }
}

