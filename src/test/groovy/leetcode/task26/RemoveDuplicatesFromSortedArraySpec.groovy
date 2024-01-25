package leetcode.task26;

import spock.lang.Specification;

class RemoveDuplicatesFromSortedArraySpec extends Specification {

    RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray()

    def "test solution"() {
        given:
        int[] input = nums
        int[] expectedArray = expected

        expect:
        n == solution.removeDuplicates(input)
        expectedArray == input;

        where:
        nums                           | n | expected
        [1, 1, 2]                      | 2 | [1, 2, 2]
        [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] | 5 | [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]
        [1, 2, 3]                      | 3 | [1, 2, 3]
    }

}