import java.util.Date;
import java.util.Random;

/**
 * The `Employee` class represents an employee with attributes such as employee ID, first name, last name, and date of birth.
 */
public class Employee {
    private long employeeID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    /**
     * Constructs an `Employee` object with the specified first name, last name, and date of birth.
     *
     * @param firstName   The first name of the employee.
     * @param lastName    The last name of the employee.
     * @param dateOfBirth The date of birth of the employee.
     */
    public Employee(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

        Random rand = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;

        employeeID = rand.nextLong(lowerBound, upperBound);
    }

    /**
     * Gets the employee's unique identifier (ID).
     *
     * @return The employee's ID.
     */
    public long getEmployeeID() {
        return employeeID;
    }

    /**
     * Gets the first name of the employee.
     *
     * @return The first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return The last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the date of birth of the employee.
     *
     * @return The date of birth of the employee.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName The first name to be set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName The last name to be set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the date of birth of the employee.
     *
     * @param dateOfBirth The date of birth to be set.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
