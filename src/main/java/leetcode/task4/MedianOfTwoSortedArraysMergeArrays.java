package leetcode.task4;

class MedianOfTwoSortedArraysMergeArrays implements MedianOfTwoSortedArrays {
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i++];
            } else {
                nums3[k] = nums2[j++];
            }

            k++;
        }

        if(i == nums1.length) {
            while(j < nums2.length) {
                nums3[k++] = nums2[j++];
            }
        } else {
            while(i < nums1.length) {
                nums3[k++] = nums1[i++];
            }
        }

        return k % 2 == 0 ?
                (nums3[k / 2] + nums3[(k / 2) - 1]) / 2.0 :
                nums3[k / 2];
    }
}
