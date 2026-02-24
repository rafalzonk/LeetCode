package leetcode.countgoodmeals;

import static java.util.Arrays.sort;

public class CountGoodMeals {
    static int[] powersOfTwo = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304};

    public int countPairs(int[] deliciousness) {
        sort(deliciousness);
        int[] convertedDeliciousness = convertDeliciousness(deliciousness);

        long result = 0;
        final int maxMealDeliciousnessIndex = calculateMaxDeliciousnessIndex(convertedDeliciousness.length);

        for (int firstFood = 0; firstFood < convertedDeliciousness.length; firstFood++) {
            if (convertedDeliciousness[firstFood] != 0) {
                for (int j = maxMealDeliciousnessIndex; j >= 0 && powersOfTwo[j] >= 2 * firstFood; j--) {
                    int secondFood = powersOfTwo[j] - firstFood;
                    if (secondFood < convertedDeliciousness.length && convertedDeliciousness[secondFood] > 0) {
                        if (secondFood == firstFood) {
                            if (convertedDeliciousness[firstFood] > 1)
                                result += ((long) convertedDeliciousness[firstFood] * (convertedDeliciousness[firstFood] - 1)) / 2;
                        } else {
                            result += (long) convertedDeliciousness[firstFood] * convertedDeliciousness[secondFood];
                        }
                    }
                }
            }
        }

        return (int) (result % (1000_000_000 + 7));
    }

    private int calculateMaxDeliciousnessIndex(int max) {
        int ret = 0;
        while (2 * max > powersOfTwo[ret])
            ret++;
        return ret;
    }

    private int[] convertDeliciousness(int[] deliciousness) {
        int[] result = new int[deliciousness[deliciousness.length - 1] + 1];
        for (int j : deliciousness) {
            result[j]++;
        }
        return result;
    }
}
