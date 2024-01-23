package leetcode.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWithPointers implements ThreeSum {

    @Override
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j, k;
        int sum;
        int oldI, oldJ, oldK;

        while (i < nums.length - 2) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));

                    oldJ = nums[j];
                    while (j < nums.length - 1 && oldJ == nums[j]) j++;

                    oldK = nums[k];
                    while (k > j && oldK == nums[k]) k--;
                } else if (sum < 0) {
                    j++;
                } else { //sum > 0
                    k--;
                }
            }

            oldI = nums[i];
            while (i < nums.length - 2 && oldI == nums[i]) i++;
        }

        return result;
    }
}
