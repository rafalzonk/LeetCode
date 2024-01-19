package leetcode.task4

import spock.lang.Shared
import spock.lang.Specification

abstract class MedianOfTwoSortedArraysSpec extends Specification {
    @Shared
    MedianOfTwoSortedArrays solution

    def "test solution"() {
        given:
        int[] nums1 = arr1
        int[] nums2 = arr2

        expect:
        double result = median
        result == solution.findMedianSortedArrays(nums1, nums2)

        where:
        arr1                             | arr2                                | median
        [1, 2, 3]                        | [2, 3, 4]                           | 2.5
        [1, 2, 3, 4]                     | [2, 3, 4]                           | 3
        []                               | [1, 2, 3]                           | 2
        []                               | [1, 2, 3, 4]                        | 2.5
        [1, 2, 3]                        | []                                  | 2
        [1, 2, 3, 4]                     | []                                  | 2.5
        [1, 2, 3, 4, 5, 6, 7, 8]         | [9, 10, 11]                         | 6
        [1, 2, 3, 7, 8, 9, 10, 11]       | [4, 5, 6]                           | 6
        [1, 2, 3, 4, 5, 7, 8, 9, 10, 11] | [6]                                 | 6
        [2, 2, 3, 3, 5, 5, 6, 9, 11]     | [6, 6, 6, 7, 8, 10, 10, 11, 12, 15] | 6
        [-1, 3]                          | [1, 2]                              | 1.5
        [1, 3]                           | [2]                                 | 2
        [1, 2]                           | [3, 4]                              | 2.5
        [2, 2, 2, 2]                     | [2, 2, 2]                           | 2
        [1, 2]                           | [3, 4, 5, 6, 7, 8, 9]               | 5
        [1, 2]                           | [3, 4, 5, 6, 7, 8, 9, 10]           | 5.5
        [2]                              | [1, 3, 4]                           | 2.5
        [3, 4, 5]                        | [1, 2, 6, 7, 8]                     | 4.5
    }
}

class MedianOfTwoSortedArraysSolution1Spec extends MedianOfTwoSortedArraysSpec {
    def setupSpec() {
        solution = new MedianOfTwoSortedArraysMergeArrays()
    }
}

class MedianOfTwoSortedArraysSolution2Spec extends MedianOfTwoSortedArraysSpec {
    def setupSpec() {
        solution = new MedianOfTwoSortedArraysCountElements()
    }
}

class MedianOfTwoSortedArraysSolution3Spec extends MedianOfTwoSortedArraysSpec {
    def setupSpec() {
        solution = new MedianOfTwoSortedArraysBinaryNarrow()
    }
}
