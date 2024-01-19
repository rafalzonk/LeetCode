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

        // two singles
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
            return resolveOneSingleElement(right, left, nums, single);
        } else { //at least one double
            int first, second;
            int left, right;
            int[] nums, duble;
            if (right1 - left1 == 1) {
                first = left1;
                second = right1;
                left = left2;
                right = right2;
                nums = nums2;
                duble = nums1;
            } else {
                first = left2;
                second = right2;
                left = left1;
                right = right1;
                nums = nums1;
                duble = nums2;
            }

            while (right - left >= 2 && second > first) {
                if (duble[first] > nums[left])
                    left++;
                else
                    first++;

                if (duble[second] < nums[right])
                    right--;
                else
                    second--;
            }

            if (second == first) {
                return resolveOneSingleElement(left, right, nums, duble[first]);
            }
            if (right == left) {
                return resolveOneSingleElement(first, second, duble, nums[left]);
            }
            if (second < first) { //median within the longer array
                return median(left, right, nums);
            } else {
                //two double arrays
                return (max(nums[left], duble[first]) + min(nums[right], duble[second])) / 2.0;
            }

        }
    }

    private double resolveOneSingleElement(int left, int right, int[] nums, int single) {
        if ((right - left) % 2 == 0) {
            double oddMedian = median(left, right, nums);
            int medianIndex = (right + left) / 2;
            if (oddMedian == single) {
                return single;
            }
            if (oddMedian > single) {
                if (nums[medianIndex - 1] < single)
                    return (oddMedian + single) / 2.0;
                else
                    return (oddMedian + nums[medianIndex - 1]) / 2.0;
            }
            //oddMedian < single
            if (nums[medianIndex + 1] > single)
                return (oddMedian + single) / 2.0;
            else
                return (oddMedian + nums[medianIndex + 1]) / 2.0;
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
        return right2 - left2 > 1 &&
                right1 - left1 > 1;
    }
}
