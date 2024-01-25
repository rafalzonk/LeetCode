package leetcode.task26;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int last = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                nums[count] = nums[i];
                count++;
                last = nums[i];
            }
        }

        return count;
    }
}
