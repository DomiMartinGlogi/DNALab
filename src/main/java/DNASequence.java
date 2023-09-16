/**
 * The `DNASequence` class represents a DNA sequence with a set of valid characters.
 */
public class DNASequence {
    // A string containing the valid characters for a DNA sequence.
    private static String validChars = "ATGC";

    // The actual DNA sequence as a string.
    private String bases;

    /**
     * Constructs a `DNASequence` object with the provided DNA sequence bases.
     *
     * @param bases The DNA sequence bases as a string.
     */
    public DNASequence(String bases) {
        this.bases = bases;
    }

    /**
     * Gets the valid characters for a DNA sequence.
     *
     * @return A string containing the valid DNA characters.
     */
    public static String getValidChars() {
        return validChars;
    }

    /**
     * Sets the DNA sequence bases.
     *
     * @param bases The DNA sequence bases as a string.
     */
    public void setBases(String bases) {
        this.bases = bases;
    }

    /**
     * Gets the DNA sequence bases.
     *
     * @return The DNA sequence bases as a string.
     */
    public String getBases() {
        return bases;
    }

    /**
     * Checks the validity of the DNA sequence based on the valid characters.
     *
     * @return `true` if the DNA sequence is valid; otherwise, `false`.
     */
    public boolean checkValidity() {
        if (bases.length() == 3) {
            char[] charsInBases = bases.toCharArray();
            for (int i = 0; i < charsInBases.length; i++) {
                if (!validChars.contains(String.valueOf(charsInBases[i]))) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}
