import java.util.Date;
import java.util.Random;

public class Employee {
    private long employeeID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;


    public Employee(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

        Random rand = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;

        employeeID = rand.nextLong(lowerBound, upperBound);
    }
}
