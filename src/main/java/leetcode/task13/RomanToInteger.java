package leetcode.task13;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] roman = s.toCharArray();
        int result = 0;

        int digit = roman.length - 1;

        while (digit >= 0 && roman[digit] == 'I') {
            result += 1;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'V') {
            result += 5;
            digit--;
            if (digit >= 0 && roman[digit] == 'I') {
                result -= 1;
                digit--;
            }
        }

        if (digit >= 0 && roman[digit] == 'X') {
            result += 10;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'I') {
            result -= 1;
            digit--;
        }
        while (digit >= 0 && roman[digit] == 'X') {
            result += 10;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'L') {
            result += 50;
            digit--;
            if (digit >= 0 && roman[digit] == 'X') {
                result -= 10;
                digit--;
            }
        }

        if (digit >= 0 && roman[digit] == 'C') {
            result += 100;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'X') {
            result -= 10;
            digit--;
        }
        while (digit >= 0 && roman[digit] == 'C') {
            result += 100;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'D') {
            result += 500;
            digit--;
            if (digit >= 0 && roman[digit] == 'C') {
                result -= 100;
                digit--;
            }
        }

        if (digit >= 0 && roman[digit] == 'M') {
            result += 1000;
            digit--;
        }
        if (digit >= 0 && roman[digit] == 'C') {
            result -= 100;
            digit--;
        }
        while (digit >= 0 && roman[digit] == 'M') {
            result += 1000;
            digit--;
        }

        return result;
    }
}