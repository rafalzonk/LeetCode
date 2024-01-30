package leetcode.task34;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int t = Arrays.binarySearch(nums, target);
        if (t < 0)
            return new int[]{-1, -1};

        int first = Arrays.binarySearch(nums, target - 1);
        if (first < 0) {
            first = -first - 1;
        } else {
            first = binarySearchFirst(nums, target, first, t);
        }

        int last = Arrays.binarySearch(nums, target + 1);
        if (last < 0) {
            last = -last - 2;
        } else {
            last = binarySearchLast(nums, target, t, last);
        }

        return new int[]{first, last};
    }

    private int binarySearchLast(int[] nums, int target, int from, int to) {
        int middle = (from + to) >>> 1;

        while (from < to) {
            if (nums[middle] == target) {
                from = middle;
                if (nums[to] == target) {
                    return to;
                }
            } else {
                to = middle;
            }
            to--;
            middle = (from + to) >>> 1;
        }

        return middle;
    }

    private int binarySearchFirst(int[] nums, int target, int from, int to) {
        int middle = (from + to) >>> 1;

        while (from < to) {
            if (nums[middle] == target) {
                to = middle;
            } else {
                from = middle;
                from++;
            }
            middle = (from + to) >>> 1;
        }

        return middle;
    }
}
