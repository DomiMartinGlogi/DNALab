import java.util.ArrayList;
import java.util.Random;

/**
 * The `Report` class represents a report with attributes such as report ID, employee, description, distance, comment, and samples.
 */
public class Report {
    private long reportID;
    private Employee employee;
    private String description;
    private int distance;
    private String comment;
    private Sample samples[];

    /**
     * Constructs a `Report` object with the specified employee, description, comment, and samples.
     *
     * @param employee    The employee who generated the report.
     * @param description A description of the report.
     * @param comment     Additional comments on the report.
     * @param samples     An array of samples included in the report.
     */
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

    /**
     * Gets the unique identifier (ID) of the report.
     *
     * @return The report's ID.
     */
    public long getReportID() {
        return reportID;
    }

    /**
     * Gets the employee who generated the report.
     *
     * @return The employee object.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Gets the description of the report.
     *
     * @return The report's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the evolutionary distance between the samples in the report.
     *
     * @return The evolutionary distance.
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Gets additional comments on the report.
     *
     * @return The report's comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Gets the array of samples included in the report.
     *
     * @return An array of Sample objects.
     */
    public Sample[] getSamples() {
        return samples;
    }

    /**
     * Sets the description of the report.
     *
     * @param description The description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets additional comments on the report.
     *
     * @param comment The comment to be set.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Calculates the evolutionary distance between the samples in the report.
     *
     * @return The calculated evolutionary distance.
     */
    public int calculateDistance() {
        if (samples.length != 2) {
            return 0;
        }

        Sample sample1 = samples[0];
        Sample sample2 = samples[1];
        ArrayList<DNASequence> seq1 = sample1.getContents();
        ArrayList<DNASequence> seq2 = sample2.getContents();

        // Calculate the total distance for this pair.
        int totalDistance = 0;

        for (int k = 0; k < seq1.size(); k++) {
            String bases1 = seq1.get(k).getBases();
            String bases2 = seq2.get(k).getBases();

            if (!bases1.equals(bases2)) {
                // Gene replacement costs 3.
                totalDistance += 3;
            }
        }

        // Calculate the difference in gene counts.
        int diff = Math.abs(seq1.size() - seq2.size());
        // Deleting a gene or creating a gene costs 2 each.
        totalDistance += 2 * diff;

        return totalDistance;
    }

}
