import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReportTest {
    private ArrayList<Sample> samples;

    @BeforeEach
    void setUp() {
        // Create sample data for testing.
        ArrayList<DNASequence> seq1 = new ArrayList<>(Arrays.asList(
                new DNASequence("ATG"),
                new DNASequence("TAA")
        ));

        ArrayList<DNASequence> seq2 = new ArrayList<>(Arrays.asList(
                new DNASequence("ATG"),
                new DNASequence("TAC"),
                new DNASequence("TAA")
        ));

        ArrayList<DNASequence> seq3 = new ArrayList<>(Arrays.asList(
                new DNASequence("ATG"),
                new DNASequence("TGC")
        ));

        Sample sample1 = new Sample(seq1);
        Sample sample2 = new Sample(seq2);
        Sample sample3 = new Sample(seq3);

        samples = new ArrayList<>(Arrays.asList(sample1, sample2, sample3));
    }

    @Test
    void calculateDistanceWithNoSamples() {
        Report report = new Report(new Employee("John", "Doe", null), "Description", "Comment", new Sample[]{});
        int distance = report.calculateDistance();
        assertEquals(0, distance);
    }

    @Test
    void calculateDistanceWithSingleSample() {
        Report report = new Report(new Employee("John", "Doe", null), "Description", "Comment", new Sample[]{samples.get(0)});
        int distance = report.calculateDistance();
        assertEquals(0, distance); // Single sample, no distance.
    }

    @Test
    void calculateDistanceWithTwoIdenticalSamples() {
        Report report = new Report(new Employee("John", "Doe", null), "Description", "Comment", new Sample[]{samples.get(0), samples.get(0)});
        int distance = report.calculateDistance();
        assertEquals(0, distance); // Identical samples, no distance.
    }

    @Test
    void calculateDistanceWithTwoDifferentSamples() {
        Report report = new Report(new Employee("John", "Doe", null), "Description", "Comment", new Sample[]{samples.get(0), samples.get(2)});
        int distance = report.calculateDistance();
        assertEquals(3, distance); // Expected distance: 3 (replacement cost).
    }
}
