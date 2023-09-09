
public class DNASequence {
    private static String validChars = "A T G C";
    private String bases;

    public DNASequence(String bases) {
        this.bases = bases;
    }

    public String getBases() {
        return bases;
    }

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