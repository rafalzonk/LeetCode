package leetcode.jump_game

import spock.lang.Specification

class JumpGameTest extends Specification {
    JumpGame solution = new JumpGame()

    def "test solution"() {
        expect:
        solution.canJump(input as int[]) == result

        where:
        input                                                  || result
        [2, 3, 1, 1, 4]                                        || true
        [3, 2, 1, 0, 4]                                        || false
        [4]                                                    || true
        [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1] || true
        [4, 3, 2, 1, 0]                                        || true
    }
}
