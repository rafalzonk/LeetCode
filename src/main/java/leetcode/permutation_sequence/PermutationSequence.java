package leetcode.permutation_sequence;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class PermutationSequence {
    private static final int[] FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};
    public static final List<Integer> DIGITS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>(DIGITS);
        int result = 0;

        while (n > 1) {
            int digit = k % FACTORIALS[n - 1] == 0 ? k / FACTORIALS[n - 1] : 1 + k / FACTORIALS[n - 1];
            result *= 10;
            result += digits.remove(digit - 1);
            n--;
            k %= FACTORIALS[n];
            if (k == 0)
                k = FACTORIALS[n];
        }
        while (n-- > 0) {
            result *= 10;
            result += digits.removeFirst();
        }

        return valueOf(result);
    }
}