package leetcode.permutation_sequence

import spock.lang.Specification

class PermutationSequenceTest extends Specification {

    PermutationSequence solution = new PermutationSequence()

    def "test solution"() {
        expect:
        solution.getPermutation(n, k) == result

        where:
        n | k || result
        1 | 1 || "1"
        2 | 1 || "12"
        2 | 2 || "21"
        3 | 1 || "123"
        3 | 2 || "132"
        3 | 3 || "213"
        4 | 6 || "1432"
        4 | 8 || "2143"
        4 | 9 || "2314"
    }
}
