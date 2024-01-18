package leetcode.task4;

public class MedianOfTwoSortedArraysBinaryNarrow implements MedianOfTwoSortedArrays {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0, left2 = 0;
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;

        int cut1, cut2, med1, med2;


        while (arraysNarrowable(right1, left1, right2, left2)) {
            med1 = medianIndex(left1, right1);
            med2 = medianIndex(left2, right2);

            if (median(left1, right1, nums1) <= median(left2, right2, nums2)) {
                cut1 = med1 - left1;
                cut2 = right2 - med2;
            } else {
                cut1 = med2 - left2;
                cut2 = right1 - med1;
            }

            if (cut1 <= cut2 && cut1 > 0) {
                left1 += cut1;
                right2 -= cut1;
            } else {
                left2 += cut2;
                right1 -= cut2;
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            if (left1 > right1) {
                return median(left2, right2, nums2);
            } else if (left2 > right2) {
                return median(left1, right1, nums1);
            } else {
                return (nums1[left1] + nums2[left2]) / 2.0;
            }
        } else {
            if (left1 > right1) {
                return median(left2, right2, nums2);
            } else {
                return median(left1, right1, nums1);
            }
        }
    }

    private int medianIndex(int left, int right) {
        return (right + left) / 2;
    }

    private double median(int left, int right, int[] nums) {
        int medianIndex = (right + left) / 2;
        if ((right - left) % 2 == 0) {
            return (nums[medianIndex] + nums[medianIndex + 1]) / 2.0;
        } else return nums[medianIndex];
    }

    private static boolean arraysNarrowable(int right1, int left1, int right2, int left2) {
        return right1 > left1 &&
                right2 > left2 &&
                right2 + right1 - left2 - left1 > 2;
    }
}
