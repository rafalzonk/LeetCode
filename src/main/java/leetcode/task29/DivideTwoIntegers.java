package leetcode.task29;

import static java.lang.Integer.*;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == 0)
            return 0;

        if (divisor == dividend)
            return 1;
        if (divisor == -dividend)
            return -1;

        if (divisor == 1)
            return dividend;
        if (divisor == -1)
            return dividend == MIN_VALUE ? MAX_VALUE : -dividend;

        if (dividend == MIN_VALUE && divisor == MAX_VALUE)
            return -1;
        if (divisor == MAX_VALUE || divisor == MIN_VALUE)
            return 0;

        if ((dividend > 0 && divisor > 0 && divisor > dividend) ||
                (dividend < 0 && divisor < 0 && divisor < dividend) ||
                (dividend > 0 && divisor < 0 && dividend < -divisor) ||
                (dividend < 0 && divisor > 0 && dividend > -divisor))
            return 0;

        int result = 0;

        if (dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                result++;
            }
        } else if (dividend > 0 && divisor < 0) {
            while (dividend >= -divisor) {
                dividend += divisor;
                result--;
            }
        } else if (dividend < 0 && divisor > 0) {
            while (dividend <= -divisor) {
                dividend += divisor;
                result--;
            }
        } else { //dividend < 0 && divisor < 0
            while (dividend <= divisor) {
                dividend -= divisor;
                result++;
            }
        }

        return result;
    }
}
