import java.util.ArrayList;
import java.util.Random;

/**
 * The `Lab` class represents a laboratory with attributes such as lab ID, employees, address, postal code, and country.
 */
public class Lab {
    private long labID;
    private ArrayList<Employee> employees;
    private String address;
    private String postalCode;
    private String country;

    /**
     * Constructs a `Lab` object with the specified employees, address, postal code, and country.
     *
     * @param employees   The list of employees working in the lab.
     * @param address     The address of the lab.
     * @param postalCode  The postal code of the lab's location.
     * @param country     The country where the lab is located.
     */
    public Lab(ArrayList<Employee> employees, String address, String postalCode, String country) {
        this.employees = employees;
        this.address = address;
        this.postalCode = postalCode;
        this.country = country;

        Random rand = new Random();
        long lowerBound = 0L;
        long upperBound = 999_999_999L;

        labID = rand.nextLong(lowerBound, upperBound);
    }

    /**
     * Gets the unique identifier (ID) of the lab.
     *
     * @return The lab's ID.
     */
    public long getLabID() {
        return labID;
    }

    /**
     * Gets the list of employees working in the lab.
     *
     * @return The list of employees.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Gets the address of the lab.
     *
     * @return The lab's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the postal code of the lab's location.
     *
     * @return The lab's postal code.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Gets the country where the lab is located.
     *
     * @return The lab's country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the list of employees working in the lab.
     *
     * @param employees The list of employees to be set.
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * Sets the address of the lab.
     *
     * @param address The address to be set.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Sets the postal code of the lab's location.
     *
     * @param postalCode The postal code to be set.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Sets the country where the lab is located.
     *
     * @param country The country to be set.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
