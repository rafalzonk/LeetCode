package leetcode.task31;

import spock.lang.Specification;

class NextPermutationSpec extends Specification {

    NextPermutation solution = new NextPermutation()

    def "test solution"() {
        given:
        int[] input = nums

        when:
        solution.nextPermutation(input)

        then:
        result as int[] == input

        where:
        nums               | result
        [1]                | [1]
        [1, 2]             | [2, 1]
        [1, 2, 3]          | [1, 3, 2]
        [3, 2, 1]          | [1, 2, 3]
        [2, 3, 1]          | [3, 1, 2]
        [1, 1, 5]          | [1, 5, 1]
        [1, 5, 1]          | [5, 1, 1]
        [5, 4, 3, 2, 1]    | [1, 2, 3, 4, 5]
        [1, 2, 3, 4, 5]    | [1, 2, 3, 5, 4]
        [1, 2, 3, 5, 4]    | [1, 2, 4, 3, 5]
        [1, 2, 4, 3, 5]    | [1, 2, 4, 5, 3]
        [1, 2, 4, 5, 3]    | [1, 2, 5, 3, 4]
        [1, 2, 5, 3, 4]    | [1, 2, 5, 4, 3]
        [1, 2, 5, 4, 3]    | [1, 3, 2, 4, 5]
        [1, 3, 2, 4, 5]    | [1, 3, 2, 5, 4]
        [1, 3, 2, 5, 4]    | [1, 3, 4, 2, 5]
        [1, 3, 4, 2, 5]    | [1, 3, 4, 5, 2]
        [1, 3, 4, 5, 2]    | [1, 3, 5, 2, 4]
        [1, 3, 5, 2, 4]    | [1, 3, 5, 4, 2]
        [1, 4, 2, 3, 5]    | [1, 4, 2, 5, 3]
        [1, 4, 2, 5, 3]    | [1, 4, 3, 2, 5]
        [1, 4, 5, 2, 3]    | [1, 4, 5, 3, 2]
        [1, 4, 5, 3, 2]    | [1, 5, 2, 3, 4]
        [5, 4, 7, 5, 3, 2] | [5, 5, 2, 3, 4, 7]
    }

}