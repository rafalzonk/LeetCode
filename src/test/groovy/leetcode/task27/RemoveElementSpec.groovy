package leetcode.task27;

import spock.lang.Specification;

class RemoveElementSpec extends Specification {
    RemoveElement solution = new RemoveElement()

    def "test solution"() {
        given:
        int[] nums = input
        int[] expectedNums = output

        expect:
        result == solution.removeElement(nums, val)
        nums == expectedNums

        where:
        input                    | val | result | output
        [3, 2, 2, 3]             | 3   | 2      | [2, 2, -1, -1]
        [0, 1, 2, 2, 3, 0, 4, 2] | 2   | 5      | [0, 1, 4, 0, 3, -1, -1, -1]
        [1]                      | 1   | 0      | [-1]
        [1]                      | 0   | 1      | [1]
        [3, 3]                   | 5   | 2      | [3, 3]
    }
}