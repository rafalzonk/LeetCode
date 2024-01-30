package leetcode.task33

import spock.lang.Shared;
import spock.lang.Specification;

class SearchInRotatedSortedArraySpec extends Specification {

    @Shared
    SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray()

    def "test solution"() {
        expect:
        result == solution.search(nums as int[], target)

        where:
        nums                  | target | result
        [4, 5, 6, 7, 0, 1, 2] | 0      | 4
        [4, 5, 6, 7, 0, 1, 2] | 3      | -1
        [1]                   | 0      | -1
        [1, 3]                | 3      | 1
        [3, 5, 1]             | 5      | 1
        [4, 5, 6, 7, 0, 1, 2] | 1      | 5
    }

    def "test rotatedBinarySearch"() {
        given:
        def right = nums.size() - 1

        expect:
        result == solution.rotatedBinarySearch(nums as int[], 0, right, target)

        where:
        nums                  | target | result
        [0, 1, 2, 3]          | 2      | 2
        [0, 1, 2, 4]          | 3      | -4
        [5, 6, 0, 1, 2]       | 1      | 3
        [5, 6, 0, 1, 2]       | 3      | -1
        [3, 4, 5, 6, 1]       | 4      | 1
        [3, 4, 5, 6, 1]       | 1      | 4
        [1, 3]                | 3      | 1
        [3, 5, 1]             | 5      | 1
        [4, 5, 6, 7, 0, 1, 2] | 1      | 5
    }
}
