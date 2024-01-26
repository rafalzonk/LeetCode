package leetcode.task27;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int removed = 0;

        while (left <= right) {
            while (right >= 0 && nums[right] == val) {
                nums[right] = -1;
                removed++;
                right--;
            }
            if (left >= right)
                return nums.length - removed;
            while (left < nums.length && nums[left] != val) {
                left++;
            }
            if (left >= right) {
                return nums.length - removed;
            }
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = -1;
                removed++;
                right--;
                left++;
            }
        }

        return nums.length - removed;
    }
}
