package java112.project3;


/**
 *  This is a JavaBean to demonstrate using beans with JSP.
 *
 *@author    eknapp
 */
public class BeanOne {

    private String data;
    private String firstName;


    /**
     *  Constructor for the BeanOne object
     */
    public BeanOne() {
        data = "default value";
        firstName = "<unknown>";
    }


    /**
     * Returns the value of firstName.
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Sets the value of firstName.
     * @param firstName The value to assign firstName.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     *  Gets the Data attribute of the BeanOne object
     *
     *@return    The Data value
     */
    public String getData() {
        return data;
    }


    /**
     *  Sets the Data attribute of the BeanOne object
     *
     *@param  data  The new Data value
     */
    public void setData(String data) {
        this.data = data;
    }
}
