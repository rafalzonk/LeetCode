package leetcode.task15;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;
import static java.util.Arrays.binarySearch;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        long timeMillis = System.currentTimeMillis();
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int sum, lastI = MIN_VALUE, lastJ = MIN_VALUE;
        int firstK = nums[nums.length - 1];
        int k;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] != lastI) {
                lastI = nums[i];
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[j] != lastJ) {
                        lastJ = nums[j];
                        sum = nums[i] + nums[j];
                        if (firstK >= -sum) {
                            k = binarySearch(nums, j + 1, nums.length, -sum);
                            if (k >= 2) {
                                result.add(List.of(nums[i], nums[j], nums[k]));
                            }
                        }
                    }
                }
            }
        }

        System.out.println(System.currentTimeMillis() - timeMillis);
        return result;
    }
}
