import org.jetbrains.annotations.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * The `Sample` class represents a DNA sample with its attributes and methods for managing DNA sequences.
 */
public class Sample {
    private static String[] validEndSeq = {"TGA", "TAG", "TAA"};
    private int length;
    private ArrayList<DNASequence> contents;
    private long id;
    private String origin;
    private Date dateFound;

    /**
     * Constructs a `Sample` object with the specified attributes.
     *
     * @param length      The length of the sample.
     * @param origin      The origin of the sample.
     * @param dateFound   The date when the sample was found.
     */
    public Sample(int length, String origin, Date dateFound) {
        this.length = length;
        this.origin = origin;
        this.dateFound = dateFound;

        Random rand = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;

        id = rand.nextLong(lowerBound, upperBound);

        contents = new ArrayList<DNASequence>();
    }

    /**
     * Constructs a `Sample` object with the specified attributes.
     *
     * @param length      The length of the sample.
     * @param contents    The list of DNA sequences in the sample.
     * @param origin      The origin of the sample.
     * @param dateFound   The date when the sample was found.
     */
    public Sample(int length, ArrayList<DNASequence> contents, String origin, Date dateFound) {
        this.length = length;
        this.contents = contents;
        this.origin = origin;
        this.dateFound = dateFound;

        Random rand = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;

        id = rand.nextLong(lowerBound, upperBound);
    }

    /**
     * Constructs a `Sample` object with the specified list of DNA sequences.
     *
     * @param contents    The list of DNA sequences in the sample.
     */
    public Sample(ArrayList<DNASequence> contents) {
        this.contents = contents;
        length = contents.size();
        dateFound = Date.from(Instant.now());
        origin = "TestData";
        Random rand = new Random();
        long lowerBound = 1000000000L;
        long upperBound = 9999999999L;

        id = rand.nextLong(lowerBound, upperBound);
    }

    /**
     * Adds a DNA sequence to the sample.
     *
     * @param seq The DNA sequence to be added.
     */
    public void addSequence(DNASequence seq) {
        contents.add(seq);
    }

    /**
     * Adds a list of DNA sequences to the sample.
     *
     * @param sequences The list of DNA sequences to be added.
     */
    public void addSequences(@NotNull ArrayList<DNASequence> sequences) {
        for (var seq : sequences) {
            contents.add(seq);
        }
    }

    /**
     * Checks the validity of the sample, including the validity of contained DNA sequences and their end sequences.
     *
     * @return `true` if the sample is valid; otherwise, `false`.
     */
    public boolean checkValidity() {
        for (DNASequence seq : contents) {
            if (!seq.checkValidity()) {
                return false;
            }
        }

        if (contents.size() < 1) {
            return false;
        }

        if (!contents.get(0).getBases().equals("ATG")) {
            return false;
        }

        String lastBase = contents.get(contents.size() - 1).getBases();
        boolean validEnd = false;

        for (var endSeq : validEndSeq) {
            if (endSeq.equals(lastBase)) {
                validEnd = true;
            }
        }

        return validEnd;
    }

    /**
     * Returns a string representation of the `Sample` object, including its ID and concatenated DNA sequences.
     *
     * @return A string representation of the `Sample` object.
     */
    @Override
    public String toString() {
        String result = "Sample ID : " + id + " : ";

        for (DNASequence seq : contents) {
            result.concat(seq.getBases());
        }

        return result;
    }

    /**
     * Gets the list of DNA sequences in the sample.
     *
     * @return The list of DNA sequences.
     */
    public ArrayList<DNASequence> getContents() {
        return contents;
    }

    /**
     * Sets the list of DNA sequences in the sample.
     *
     * @param contents The list of DNA sequences to be set.
     */
    public void setContents(ArrayList<DNASequence> contents) {
        this.contents = contents;
        this.length = contents.size();
    }

    /**
     * Gets the origin of the sample.
     *
     * @return The origin of the sample.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the sample.
     *
     * @param origin The origin of the sample to be set.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Gets the date when the sample was found.
     *
     * @return The date when the sample was found.
     */
    public Date getDateFound() {
        return dateFound;
    }

    /**
     * Sets the date when the sample was found.
     *
     * @param dateFound The date when the sample was found to be set.
     */
    public void setDateFound(Date dateFound) {
        this.dateFound = dateFound;
    }
}
