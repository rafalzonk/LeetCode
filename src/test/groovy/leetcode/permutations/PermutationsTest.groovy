package leetcode.permutations

import spock.lang.Specification

class PermutationsTest extends Specification {
    Permutations solution = new Permutations()

    def "test solution"() {
        expect:
        solution.permute(nums as int[]).toSet() == result.toSet()

        where:
        nums         || result
        [1, 2, 3]    || [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        [0, 1]       || [[0, 1], [1, 0]]
        [1]          || [[1]]
        [1, 2, 3, 4] || [[1, 2, 3, 4], [2, 1, 3, 4], [3, 1, 2, 4], [1, 3, 2, 4], [2, 3, 1, 4], [3, 2, 1, 4], [4, 2, 1, 3], [2, 4, 1, 3], [1, 4, 2, 3], [4, 1, 2, 3], [2, 1, 4, 3], [1, 2, 4, 3], [1, 3, 4, 2], [3, 1, 4, 2], [4, 1, 3, 2], [1, 4, 3, 2], [3, 4, 1, 2], [4, 3, 1, 2], [4, 3, 2, 1], [3, 4, 2, 1], [2, 4, 3, 1], [4, 2, 3, 1], [3, 2, 4, 1], [2, 3, 4, 1]]

    }
}
