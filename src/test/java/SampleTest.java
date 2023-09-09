import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The `SampleTest` class is a JUnit test class for testing the functionality of the `Sample` class.
 */
class SampleTest {
    ArrayList<Sample> testData;
    String[][] bases = {
            {"ATG", "TAA"},
            {"ATH", "ATG", "TAA"},
            {"ATG", "ATG", "TAC", "CCA", "TAA"},
            {"ATG"},
            {"RHS"}
    };
    boolean[] valid = {
            true,
            false,
            true,
            false,
            false
    };

    /**
     * Initializes test data by creating `Sample` objects with the provided DNA sequences.
     */
    @BeforeEach
    void setUp() {
        testData = new ArrayList<>();
        for (var base : bases) {
            ArrayList<DNASequence> sequences = new ArrayList<>();
            for (var seq : base) {
                sequences.add(new DNASequence(seq));
            }
            testData.add(new Sample(sequences));
        }
    }

    /**
     * Test case for the `checkValidity` method of the `Sample` class.
     * It verifies that the `checkValidity` method returns the expected validity results for samples.
     */
    @Test
    void checkValidity() {
        for (int i = 0; i < testData.size(); i++) {
            Assertions.assertEquals(valid[i], testData.get(i).checkValidity());
        }
    }
}
