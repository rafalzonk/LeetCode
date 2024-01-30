package leetcode.task33;

import static java.util.Arrays.binarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int index = rotatedBinarySearch(nums, 0, nums.length - 1, target);
        if (index < 0)
            return -1;

        return index;
    }

    private int rotatedBinarySearch(int[] nums, int left, int right, int target) {
        if (nums[left] == target)
            return left;
        if (left == right && nums[left] != target)
            return -1;
        if (target < nums[left] && target > nums[right])
            return -1;

        if (nums[left] < nums[right])
            return binarySearch(nums, left, right + 1, target);

        int middle = (left + right) >>> 1;
        if (nums[middle] == target)
            return middle;
        if (nums[middle] < nums[left]) {
            if (target > nums[middle] && target <= nums[right]) {
                return binarySearch(nums, middle + 1, right + 1, target);
            } else //target < nums[middle]
                return rotatedBinarySearch(nums, left + 1, middle, target);
        } else { //nums[middle] > border values
            if (target < nums[middle] && target > nums[right]) {
                return binarySearch(nums, left, middle, target);
            } else
                return rotatedBinarySearch(nums, middle + 1, right, target);
        }
    }
}