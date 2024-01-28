package leetcode.task31;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1)
            return;

        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        int max = nums[nums.length - 1];
        int i = nums.length - 1;
        while (i >= 0 && nums[i] >= max) {
            if (nums[i] > max) {
                max = nums[i];
            }
            i--;
        }
        if (i < 0) {
            revertArray(nums, 0);
            return;
        }

        int j = i + 1;
        int min = nums[j];
        int minIndex = j;
        while (j < nums.length) {
            if (nums[j] > nums[i] && nums[j] <= min) {
                min = nums[j];
                minIndex = j;
            }
            j++;
        }

        swap(nums, i, minIndex);
            revertArray(nums, i + 1);

    }

    private static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    private void revertArray(int[] nums, int from) {
        for (int i = 0; i + from < (nums.length + from) / 2; i++) {
            swap(nums, i + from, nums.length - i - 1);
        }
    }
}