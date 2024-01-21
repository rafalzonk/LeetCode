package leetcode.task9;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        if (x % 10 == 0)
            return false;

        int it = 1;
        int div = x;
        while ((div /= 10) > 0)
            it++;

        byte[] digits = new byte[it];
        it--;
        while (it >= 0) {
            digits[it--] = (byte) (x % 10);
            x /= 10;
        }
        it = 0;
        while (it < digits.length - 1 - it) {
            if (digits[it] != digits[digits.length - 1 - it])
                return false;
            it++;
        }
        return true;
    }
}