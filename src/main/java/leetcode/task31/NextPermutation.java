package leetcode.task31;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        Map<Integer, Integer> counting = new TreeMap<>();
        int max = nums[nums.length - 1];
        int i = nums.length - 1;
        while (i >= 0 && nums[i] >= max) {
            if (nums[i] > max) {
                max = nums[i];
            }
            int count = counting.getOrDefault(nums[i], 0);
            counting.put(nums[i], count + 1);
            i--;
        }
        if (i < 0) {
            revertArray(nums);
            return;
        }

        int j = i + 1;
        int min = nums[j];
        int minIndex = j;
        while (j < nums.length) {
            if (nums[j] > nums[i] && nums[j] < min) {
                min = nums[j];
                minIndex = j;
            }
            j++;
        }

        counting.put(nums[i], counting.getOrDefault(nums[i], 0) + 1);
        swap(nums, i, minIndex);
        int count = counting.get(nums[i]);
        if (count == 1) {
            counting.remove(nums[i]);
        } else {
            counting.put(nums[i], count - 1);
        }

        i++;
        for (int k : counting.keySet()) {
            count = counting.get(k);
            while (count > 0) {
                nums[i] = k;
                i++;
                count--;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void revertArray(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
    }
}