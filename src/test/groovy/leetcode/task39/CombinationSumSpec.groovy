package leetcode.task39

import spock.lang.Specification

class CombinationSumSpec extends Specification {

    CombinationSum solution = new CombinationSum()

    def "test solution"() {
        expect:
        result == solution.combinationSum(candidates as int[], target)

        where:
        candidates   | target || result
        [2, 3, 6, 7] | 7      || [[2, 2, 3], [7]]
        [2, 3, 5]    | 8      || [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        [2]          | 1      || []

    }

}
