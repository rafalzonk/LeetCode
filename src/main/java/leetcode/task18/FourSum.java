package leetcode.task18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int i = 0, j, k, l;
        long partialSum, sum;
        int oldI, oldJ, oldK, oldL;

        while (i < nums.length - 3) {
            j = i + 1;
            while (j < nums.length - 2) {
                partialSum = nums[i] + nums[j];
                k = j + 1;
                l = nums.length - 1;

                while (k < l) {
                    sum = partialSum + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));

                        oldK = nums[k];
                        while (k < l && oldK == nums[k]) k++;

                        oldL = nums[l];
                        while (l > k && oldL == nums[l]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }

                oldJ = nums[j];
                while (j < nums.length - 2 && oldJ == nums[j]) j++;
            }

            oldI = nums[i];
            while (i < nums.length - 2 && oldI == nums[i]) i++;

        }

        return result;
    }
}
