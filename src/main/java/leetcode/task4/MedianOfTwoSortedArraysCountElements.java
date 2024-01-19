package leetcode.task4;

import static java.lang.Math.min;

public class MedianOfTwoSortedArraysCountElements implements MedianOfTwoSortedArrays {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //the following two conditions could be extracted into a separate method
        if (nums1.length == 0) {
            int l = nums2.length / 2;
            return nums2.length % 2 == 0 ?
                    (nums2[l - 1] + nums2[l]) / 2.0 :
                    nums2[l];
        }
        if (nums2.length == 0) {
            int l = nums1.length / 2;
            return nums1.length % 2 == 0 ?
                    (nums1[l - 1] + nums1[l]) / 2.0 :
                    nums1[l];
        }

        int i = 0, j = 0;
        int k = (nums1.length + nums2.length - 1) / 2;
        while (i < nums1.length &&
                j < nums2.length &&
                i + j < k) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        if (i == nums1.length) { //median is within nums2
            int medianIndex = j + (k - i - j);
            if ((nums1.length + nums2.length) % 2 == 0) {
                return (nums2[medianIndex] + nums2[medianIndex + 1]) / 2.0;
            } else {
                return nums2[medianIndex];
            }
        }
        if (j == nums2.length) { //median is within nums1
            int medianIndex = i + (k - i - j);
            if ((nums1.length + nums2.length) % 2 == 0) {
                return (nums1[medianIndex] + nums1[medianIndex + 1]) / 2.0;
            } else {
                return nums1[medianIndex];

            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            int med;
            if (nums1[i] < nums2[j]) {
                med = nums1[i++];
                if (i == nums1.length) {
                    return (med + nums2[j]) / 2.0;
                }
            } else {
                med = nums2[j++];
                if (j == nums2.length) {
                    return (med + nums1[i]) / 2.0;
                }
            }

            med += min(nums1[i], nums2[j]);

            return med / 2.0;
        } else {
            return min(nums1[i], nums2[j]);
        }
    }
}
