package leetcode.firstmissingpositive;

public class FirstMissingPositive {
    public static final int LIMIT = 100_001;

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int num : nums) {
            if (num > 0) {
                if (num < min) {
                    min = num;
                } else if (num > max) {
                    max = num;
                }
            }
        }

        if (min > 1)
            return 1;

        if (max > LIMIT)
            max = LIMIT;

        int[] firstPositiveIntegers = new int[max];
        for (int num : nums) {
            if (num > 0 && num < max) {
                firstPositiveIntegers[num]++;
            }
        }
        for (int i = 1; i < max; i++) {
            if (firstPositiveIntegers[i] == 0)
                return i;
        }
        return max + 1;
    }
}
