package leetcode.jumpgame2

import spock.lang.Specification

class JumpGame2Test extends Specification {
    JumpGame2 solution = new JumpGame2()

    def "test solution"() {
        expect:
        solution.jump(nums as int[]) == result

        where:
        nums                                 || result
        [2, 3, 1, 1, 4]                      || 2
        [2, 3, 0, 1, 4]                      || 2
        [1, 3, 2]                            || 2
        [2, 3, 1]                            || 1
        [5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0] || 3
    }
}
