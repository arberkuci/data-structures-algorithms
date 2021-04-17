package algos.string;

public class StringMatching {

    public boolean naiveStringMatching(String pattern, String text) {
        if (pattern == null && text == null) return false;
        if (pattern.length() > text.length()) return false;
        int patternLength = pattern.length();
        int textLength = text.length();
        char[] patternChars = pattern.toCharArray();
        char[] textChars = text.toCharArray();
        for (int shift = 0; shift <= textLength - patternLength; shift++)
            if (samePattern(textChars, patternChars, shift)) return true;
        return false;
    }

    private boolean samePattern(char[] textChars, char[] patternChars, int shift) {
        for (int i = 0; i < patternChars.length; i++) {
            if (textChars[shift + i] != patternChars[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "acdabsbababkjasndkjansdkajdahbsdjhasdbjkalsdlamsdlkans";
        String pattern = "dlkan";
        StringMatching stringMatching = new StringMatching();
        System.out.println(stringMatching.naiveStringMatching(pattern, text));
    }

}
