import static java.lang.Math.min;

public class ValidBracketSequence {

    /*
        Idea: to keep track of the amount of opening brackets for each type, add +1 if opening or -1 if closing.
              A sequence is valid iff each count never went below 0 (this means there is not closing bracket without
              an opening one before) and in the end all counts are equal to 0.
    */

    private static boolean  isOpeningBracket(char c) {
        return c == '[' || c == '{' || c == '(';
    }

    private static int getBacketType(char c) {
        return switch (c) {
            case '{', '}' -> 0;
            case '[', ']' -> 1;
            default -> 2;
        };
    }

    public static boolean isValidSequence(String str) {
        int [] counts = {0, 0, 0};
        int minCount = 0;

        for (int i = 0; i < str.length(); i++) {
            int type = getBacketType(str.charAt(i));
            counts[type] += isOpeningBracket(str.charAt(i))? +1 : -1;
            minCount = min(minCount, counts[type]);
        }

        return minCount == 0 && counts[0] == 0 && counts[1] == 0 && counts[2] == 0;
    }


}
