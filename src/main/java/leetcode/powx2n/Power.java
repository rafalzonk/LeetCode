package leetcode.powx2n;

public class Power {
    private static final int[] POWERS_OF_TWO = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};

    public double myPow(double x, int n) {
        if (x == 1.0 || x == 0.0 || n == 1)
            return x;
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }
        if (n == 0)
            return 1.0;
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }

        double result = 1.0;
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        if (n >= 16) {
            return hornersPow(x, n);
        }

        while (n > 0) {
            result *= x;
            n--;
        }

        return result;
    }

    private double hornersPow(double x, int n) {
        int maxPow = 0;
        while (maxPow < POWERS_OF_TWO.length && POWERS_OF_TWO[maxPow] <= n) {
            maxPow++;
        }

        double[] powsOfX = new double[maxPow];
        powsOfX[0] = x;

        for (int i = 1; i < maxPow; i++) {
            powsOfX[i] = powsOfX[i - 1] * powsOfX[i - 1];
        }

        double result = 1.0;

        while (maxPow > 0 && n > 0) {
            maxPow--;
            if (POWERS_OF_TWO[maxPow] <= n) {
                result *= powsOfX[maxPow];
                n -= POWERS_OF_TWO[maxPow];
            }
        }

        return result;
    }
}
