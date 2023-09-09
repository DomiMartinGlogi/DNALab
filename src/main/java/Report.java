import java.util.Random;

public class Report {
    private long reportID;
    private Employee employee;
    private String description;
    private int distance;
    private String comment;
    private Sample samples[];


    public Report(Employee employee, String description, String comment, Sample[] samples) {
        this.employee = employee;
        this.description = description;
        this.comment = comment;
        this.samples = samples;

        Random rand = new Random();
        long lowerBound = 10_000_000_000L;
        long upperBound = 19_999_999_999L;

        reportID = rand.nextLong(lowerBound, upperBound);

        distance = calculateDistance();
    }

    public long getReportID() {
        return reportID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getDescription() {
        return description;
    }

    public int getDistance() {
        return distance;
    }

    public String getComment() {
        return comment;
    }

    public Sample[] getSamples() {
        return samples;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int calculateDistance() {
        int ret = 0;

        return ret;
    }
}
