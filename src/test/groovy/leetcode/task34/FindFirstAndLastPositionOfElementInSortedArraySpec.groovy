package leetcode.task34;

import spock.lang.Specification;

class FindFirstAndLastPositionOfElementInSortedArraySpec extends Specification {
    FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray()

    def "test solution"() {
        expect:
        result as int[] == solution.searchRange(nums as int[], target)

        where:
        nums                                                                 | target | result
        [5, 7, 7, 8, 8, 10]                                                  | 8      | [3, 4]
        [5, 7, 7, 8, 8, 10]                                                  | 6      | [-1, -1]
        []                                                                   | 0      | [-1, -1]
        [1, 2, 3]                                                            | 1      | [0, 0]
        [0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10] | 4      | [10, 13]
    }

}