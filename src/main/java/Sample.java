
import org.jetbrains.annotations.NotNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Sample {
    private static String[] validEndSeq = {"TGA", "TAG", "TAA"};
    private int length;
    private ArrayList<DNASequence> contents;
    private long id;
    private String origin;
    private Date dateFound;

    public Sample(int length, int id, String origin, Date dateFound) {
        this.length = length;
        this.id = id;
        this.origin = origin;
        this.dateFound = dateFound;

        contents = new ArrayList<DNASequence>();
    }

    public Sample(int length, ArrayList<DNASequence> contents, int id, String origin, Date dateFound) {
        this.length = length;
        this.contents = contents;
        this.id = id;
        this.origin = origin;
        this.dateFound = dateFound;
    }

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


    public void addSequence(DNASequence seq){
        contents.add(seq);
    }

    public void addSequences(@NotNull ArrayList<DNASequence> sequences) {
        for (var seq: sequences) {
            contents.add(seq);
        }
    }

    public boolean checkValidity(){
        for (DNASequence seq : contents) {
            if (!seq.checkValidity()){
                return false;
            }
        }

        if (contents.size() < 1){
            return false;
        }

        if (contents.get(0).getBases() != "ATG") {
            return false;
        }

        String lastBase = contents.get(contents.size() - 1).getBases();

        boolean validEnd = false;

        for (var endSeq: validEndSeq) {
            if (endSeq.equals(lastBase)) {
                validEnd = true;
            }
        }

        return validEnd;
    }

    @Override
    public String toString(){
        String result = "Sample ID : " + id + " : ";

        for (DNASequence seq: contents) {
            result.concat(seq.getBases());
        }

        return result;
    }
}