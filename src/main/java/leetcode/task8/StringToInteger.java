package leetcode.task8;

public class StringToInteger {

    public static final int ZERO = 48;
    public static final int ABOVE_NINE = 58;

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int multiplier = chars[0] == '-' ? -1 : 1;

        int i = 0;
        if (chars[0] == '+' || chars[0] == '-')
            i++;

        long result = 0;
        int ctoi;

        while (i < chars.length) {
            ctoi = chars[i];
            if (ctoi >= ZERO && ctoi < ABOVE_NINE) {
                result *= 10;
                result += (ctoi - ZERO);
                if (result >= Integer.MAX_VALUE)
                    break;
            } else
                break;
            i++;
        }

        result *= multiplier;
        if (result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
