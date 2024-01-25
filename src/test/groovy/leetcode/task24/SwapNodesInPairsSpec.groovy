package leetcode.task24

import leetcode.common.ListNode
import leetcode.common.ListNodes;
import spock.lang.Specification;

class SwapNodesInPairsSpec extends Specification {

    SwapNodesInPairs solution = new SwapNodesInPairs()

    def "test solution"() {
        given:
        int[] result = expected
        ListNode expectedResult = ListNodes.of(result).head

        int[] values = input
        ListNode head = ListNodes.of(values).head

        expect:
        expectedResult == solution.swapPairs(head)

        where:
        input                 | expected
        []                    | []
        [1]                   | [1]
        [1, 2]                | [2, 1]
        [1, 2, 3]             | [2, 1, 3]
        [1, 2, 3, 4, 5, 6]    | [2, 1, 4, 3, 6, 5]
        [1, 2, 3, 4, 5, 6, 7] | [2, 1, 4, 3, 6, 5, 7]
    }

}