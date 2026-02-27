package leetcode.firstmissingpositive

import spock.lang.Specification

class FirstMissingPositiveTest extends Specification {

    FirstMissingPositive solution = new FirstMissingPositive()

    def "test solution"() {
        expect:
        solution.firstMissingPositive(nums as int[]) == result

        where:
        nums               || result
        [1, 2, 0]          || 3
        [3, 4, -1, 1]      || 2
        [7, 8, 9, 11, 12]  || 1
        [-1, -2, -3]       || 1
        [1, 1, 1, 3, 3, 2] || 4
    }

}
