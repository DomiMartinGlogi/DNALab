import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

/**
 * The `DNASequenceTest` class is a JUnit test class for testing the functionality of the `DNASequence` class.
 */
class DNASequenceTest {
    private DNASequence[] testData;

    // Arrays containing test data for DNA sequences and their expected validity results.
    static String[] bases = {"ATG", "AAC", "ATG", "ARG", "GGC", "TGC", "ATG", "ABCD", "ATH", "TGC"};
    static boolean[] basesValid = {true, true, true, false, true, true, true, false, false, true};

    /**
     * Sets up the test data by creating `DNASequence` objects with the provided bases.
     */
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ArrayList<DNASequence> test = new ArrayList<>();
        for (var base : bases) {
            test.add(new DNASequence(base));
        }
        testData = test.toArray(DNASequence[]::new);
    }

    /**
     * Test case for the `getBases` method of the `DNASequence` class.
     * It verifies that the `getBases` method returns the expected DNA sequence bases.
     */
    @org.junit.jupiter.api.Test
    void getBases() {
        for (int i = 0; i < testData.length; i++) {
            assertEquals(bases[i], testData[i].getBases());
        }
    }

    /**
     * Test case for the `checkValidity` method of the `DNASequence` class.
     * It verifies that the `checkValidity` method returns the expected validity results for DNA sequences.
     */
    @org.junit.jupiter.api.Test
    void checkValidity() {
        for (int i = 0; i < testData.length; i++) {
            assertEquals(basesValid[i], testData[i].checkValidity());
        }
    }
}
