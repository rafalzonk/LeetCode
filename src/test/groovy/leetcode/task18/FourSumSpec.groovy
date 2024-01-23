package leetcode.task18;

import spock.lang.Specification;

class FourSumSpec extends Specification {

    FourSum solution = new FourSum()

    def "test solution"() {

        given:
        int[] input = nums

        expect:
        result == solution.fourSum(input, target)

        where:
        nums                                             | target     | result
        [1, 0, -1, 0, -2, 2]                             | 0          | [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
        [2, 2, 2, 2, 2]                                  | 8          | [[2, 2, 2, 2]]
        [1000000000, 1000000000, 1000000000, 1000000000] | -294967296 | []
    }
}
