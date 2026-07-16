package leetcode.maximum_subarray

import spock.lang.Specification

class MaximumSubarrayTest extends Specification {
    MaximumSubarray solution = new MaximumSubarray()

    def "test solution"() {
        expect:
        solution.maxSubArray(nums as int[]) == result

        where:
        nums                            || result
        [-2, 1, -3, 4, -1, 2, 1, -5, 4] || 6
        [1]                             || 1
        [5, 4, -1, 7, 8]                || 23
        [-5, -4, -3, -2, -1]            || -1
        [0, 0, 0, 6, 0, 0, 0]           || 6
    }
}
