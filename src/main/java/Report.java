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
        int minTotalDistance = Integer.MAX_VALUE;

        if (samples.length < 2) {
            // Not enough samples for comparison, return 0 distance.
            return 0;
        }

        // Iterate over pairs of samples to calculate distances.
        for (int i = 0; i < samples.length - 1; i++) {
            for (int j = i + 1; j < samples.length; j++) {
                Sample sample1 = samples[i];
                Sample sample2 = samples[j];

                // Assuming each sample has a method to get its DNA sequences.
                DNASequence[] seq1 = sample1.getContents().toArray(new DNASequence[0]);
                DNASequence[] seq2 = sample2.getContents().toArray(new DNASequence[0]);

                if (seq1.length != seq2.length) {
                    // Sequences must be of the same length for comparison.
                    // You may want to handle this case differently based on your requirements.
                    continue;
                }

                // Compare each DNA sequence and calculate the distance.
                int sequenceDistance = 0;
                for (int k = 0; k < seq1.length; k++) {
                    String bases1 = seq1[k].getBases();
                    String bases2 = seq2[k].getBases();

                    if (!bases1.equals(bases2)) {
                        // Gene replacement costs 3.
                        sequenceDistance += 3;
                    }
                }

                // Calculate the total distance for this pair.
                int totalDistance = sequenceDistance;

                // Calculate the difference in gene counts.
                int diff = Math.abs(seq1.length - seq2.length);

                // Deleting a gene or creating a gene costs 2 each.
                totalDistance += 2 * diff;

                // Update the minimum total distance if needed.
                minTotalDistance = Math.min(minTotalDistance, totalDistance);
            }
        }

        return minTotalDistance;
    }
}
