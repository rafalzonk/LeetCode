package leetcode.multiplystrings;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.equals("1"))
            return num2;
        if (num2.equals("1"))
            return num1;

        int firstLength = num1.length();
        int secondLength = num2.length();

        char[] result = new char[firstLength + secondLength];
        Arrays.fill(result, '0');

        for (int i = firstLength - 1; i >= 0; i--) {
            int digit = num1.charAt(i) - '0';
            int tmp = 0;
            int mul;

            for (int j = secondLength - 1; j >= 0; j--) {
                mul = digit * (num2.charAt(j) - '0') + tmp + (result[i + j + 1] - '0');

                result[i + j + 1] = (char) (mul % 10 + '0');
                tmp = mul / 10;
            }

            result[i] = (char) (tmp + '0');
        }

        String s = new String(result);
        return s.charAt(0) == '0' ?
                s.substring(1) :
                s;
    }
}
