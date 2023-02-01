public class ValidPalindrome {
    public static boolean isPalindrome(int n) {
        var n_str = Integer.valueOf(n).toString();

        int sz = n_str.length();
        for (int i = 0; i < sz; i++)
            if (n_str.charAt(i) != n_str.charAt(sz - i - 1))
                return false;

        return true;
    }
}
