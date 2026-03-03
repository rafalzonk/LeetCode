package leetcode.permutations2

import spock.lang.Specification

class Permutations2Test extends Specification {
    Permutations2 solution = new Permutations2();

    def "test solution"() {
        expect:
        solution.permuteUnique(nums as int[]).toSet() == result.toSet()

        where:
        nums         || result
        [1, 2, 3]    || [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
        [0, 1]       || [[0, 1], [1, 0]]
        [1]          || [[1]]
        [1, 2, 3, 4] || [[1, 2, 3, 4], [2, 1, 3, 4], [3, 1, 2, 4], [1, 3, 2, 4], [2, 3, 1, 4], [3, 2, 1, 4], [4, 2, 1, 3], [2, 4, 1, 3], [1, 4, 2, 3], [4, 1, 2, 3], [2, 1, 4, 3], [1, 2, 4, 3], [1, 3, 4, 2], [3, 1, 4, 2], [4, 1, 3, 2], [1, 4, 3, 2], [3, 4, 1, 2], [4, 3, 1, 2], [4, 3, 2, 1], [3, 4, 2, 1], [2, 4, 3, 1], [4, 2, 3, 1], [3, 2, 4, 1], [2, 3, 4, 1]]
        [1, 1, 2]    || [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}
