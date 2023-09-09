import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SampleTest {
    ArrayList<Sample> testData;
    String[][] bases= {
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

    @BeforeEach
    void setUp() {
        testData = new ArrayList<>();
        for (var base: bases) {
            ArrayList<DNASequence> sequences = new ArrayList<>();
            for (var seq: base) {
                sequences.add(new DNASequence(seq));
            }
            testData.add(new Sample(sequences));
        }
    }

    @Test
    void checkValidity() {
        for (int i = 0; i < testData.size(); i++) {
            Assertions.assertEquals(valid[i], testData.get(i).checkValidity());
        }
    }
}