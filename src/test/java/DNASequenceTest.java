import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

class DNASequenceTest {
    private DNASequence[] testData;
    static String[] bases =       {"ATG", "AAC", "ATG", "ARG", "GGC", "TGC", "ATG", "ABCD", "ATH", "TGC"};
    static boolean[] basesValid = {true,  true,  true,  false, true,  true,  true,  false,  false, true};

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ArrayList<DNASequence> test = new ArrayList<>();
        for (var base: bases) {
            test.add(new DNASequence(base));
        }
        testData = test.toArray(DNASequence[]::new);
    }

    @org.junit.jupiter.api.Test
    void getBases() {
        for (int i = 0; i < testData.length; i++) {
            assertEquals(bases[i], testData[i].getBases());
        }
    }

    @org.junit.jupiter.api.Test
    void checkValidity() {
        for (int i = 0; i < testData.length; i++) {
            assertEquals(basesValid[i], testData[i].checkValidity());
        }
    }
}