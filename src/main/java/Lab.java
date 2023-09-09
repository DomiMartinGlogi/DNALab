import java.util.ArrayList;
import java.util.Random;

public class Lab {
    private long labID;
    private ArrayList<Employee> employees;
    private String address;
    private String postalCode;
    private String country;


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
}
