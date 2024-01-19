package leetcode.task4;

import static java.lang.Math.*;

public class MedianOfTwoSortedArraysBinaryNarrow implements MedianOfTwoSortedArrays {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int left1 = 0, left2 = 0;
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;

        int cut1, cut2;
        double med1, med2, medIndex1, medIndex2;

        if (nums1.length == 0) {
            return median(left2, right2, nums2);
        }
        if (nums2.length == 0) {
            return median(left1, right1, nums1);
        }

        while (arraysNarrowable(right1, left1, right2, left2)) {
            medIndex1 = medianIndex(left1, right1);
            medIndex2 = medianIndex(left2, right2);

            med1 = median(left1, right1, nums1);
            med2 = median(left2, right2, nums2);

            if (med1 == med2)
                return med1;

            if (med1 < med2) {
                cut1 = (int) (medIndex1 - left1);
                cut2 = (int) (right2 - medIndex2);
            } else {
                cut1 = (int) (medIndex2 - left2);
                cut2 = (int) (right1 - medIndex1);
            }


            int cut = min(cut1, cut2);
            if (cut == 0)
                cut = 1;

            if (med1 <= med2) {
                left1 += cut;
                right2 -= cut;
            } else {
                left2 += cut;
                right1 -= cut;
            }
        }

        // two single
        if (right1 - left1 == 0 && right2 - left2 == 0) {
            return (nums1[left1] + nums2[left2]) / 2.0;
        }

        //one single
        else if (right1 - left1 == 0 || right2 - left2 == 0) {
            int single, left, right;
            int[] nums;
            if (right1 - left1 == 0) {
                single = nums1[left1];
                nums = nums2;
                left = left2;
                right = right2;
            } else {
                single = nums2[left2];
                nums = nums1;
                left = left1;
                right = right1;
            }

            // one single, one odd
            if ((right - left) % 2 == 0) {
                double oddMedian = median(left, right, nums);
                if (oddMedian == single) {
                    return single;
                }
                if (oddMedian > single) {
                    return median(left, right - 1, nums);
                }
                return median(left + 1, right, nums);
            }
            //one single, one even
            else {
                double evenMedianIndex = medianIndex(left, right);
                left = nums[(int) evenMedianIndex];
                right = nums[(int) (evenMedianIndex + 1)];
                if (single > right)
                    return right;
                return max(single, left);
            }
        } else {
            //two doubles
            return (max(nums1[left1], nums2[left2]) + min(nums1[right1], nums2[right2])) / 2.0;
        }
    }

    private double medianIndex(int left, int right) {
        return (right + left) / 2.0;
    }

    private double median(int left, int right, int[] nums) {
        int medianIndex = (right + left) / 2;
        if ((right - left) % 2 != 0) {
            return (nums[medianIndex] + nums[medianIndex + 1]) / 2.0;
        } else return nums[medianIndex];
    }

    private static boolean arraysNarrowable(int right1, int left1, int right2, int left2) {
        return right2 - left2 >= 1 &&
                right1 - left1 >= 1 &&
                right2 + right1 - left2 - left1 > 2;
    }
}
