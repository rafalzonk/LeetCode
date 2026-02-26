package leetcode.combinationsum2

import spock.lang.Specification

class CombinationSum2Test extends Specification {

    CombinationSum2 solution = new CombinationSum2()

    def "test solution"() {
        expect:
        solution.combinationSum2(candidates as int[], target) == result

        where:
        candidates                                                                                                                                                                              | target || result
        [10, 1, 2, 7, 6, 1, 5]                                                                                                                                                                  | 8      || [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]
        [2, 5, 2, 1, 2]                                                                                                                                                                         | 5      || [[1, 2, 2], [5]]
        [2]                                                                                                                                                                                     | 1      || []
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1] | 15     || [[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]]

    }

}
