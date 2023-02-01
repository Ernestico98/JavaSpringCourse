public class Main {

    private static void tryPalindrome(int n) {
        System.out.println("testPalindrome---------------------");
        System.out.print("Testing on " + Integer.valueOf(n).toString() + ": ");
        System.out.println(ValidPalindrome.isPalindrome(n));
        System.out.println();
    }

    private static void trySequence(String sequence) {
        System.out.println("testSequence-----------------------");
        System.out.print("Testing on " + sequence + ": ");
        System.out.println(ValidBracketSequence.isValidSequence(sequence));
        System.out.println();
    }

    public static void main(String[] args) {

        // trying palindromes
        tryPalindrome(12);
        tryPalindrome(121);
        tryPalindrome(1202);
        tryPalindrome(12021);

        // trying sequences
        trySequence("{][()");
        trySequence("{[]}()");
        trySequence("{[}(])");
        trySequence("{][}()");
    }
}