package leetcode.task16;

import java.util.Arrays;

import static java.lang.Math.abs;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int missing;
        int closestSum = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int currentSum;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int partialSum = nums[i] + nums[j];
                missing = target - partialSum;
                int search = Arrays.binarySearch(nums, j + 1, nums.length, missing);
                if (search < 0)
                    search = -search - 1;

                if (search < nums.length) {
                    currentSum = partialSum + nums[search];
                    if (target == currentSum) {
                        return target;
                    }
                    if (abs(target - currentSum) < diff) {
                        closestSum = currentSum;
                        diff = abs(target - currentSum);
                    }
                }

                if (--search > j) {
                    currentSum = partialSum + nums[search];
                    if (target == currentSum) {
                        return target;
                    }
                    if (abs(target - currentSum) < diff) {
                        closestSum = currentSum;
                        diff = abs(target - currentSum);
                    }
                }
            }
        }

        return closestSum;
    }
}
