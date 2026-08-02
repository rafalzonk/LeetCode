package leetcode.rotate_list

import leetcode.common.ListNode
import leetcode.common.ListNodes
import spock.lang.Specification

class RotateListTest extends Specification {
    RotateList solution = new RotateList()

    def "test solution"() {
        given:
        ListNode result = ListNodes.of(expectedResult as int[]).head

        ListNode head = ListNodes.of(givenValues as int[]).head

        expect:
        solution.rotateRight(head, k) == result

        where:
        givenValues     | k  || expectedResult
        []              | 0  || []
        [1]             | 20 || [1]
        [1, 2]          | 3  || [2, 1]
        [1, 2]          | 4  || [1, 2]
        [1, 2, 3, 4, 5] | 2  || [4, 5, 1, 2, 3]
        [0, 1, 2]       | 4  || [2, 0, 1]
    }
}
