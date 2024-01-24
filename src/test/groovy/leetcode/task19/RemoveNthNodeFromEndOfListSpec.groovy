package leetcode.task19

import leetcode.common.ListNode
import leetcode.common.ListNodes;
import spock.lang.Specification;

class RemoveNthNodeFromEndOfListSpec extends Specification {

    RemoveNthNodeFromEndOfList solution = new RemoveNthNodeFromEndOfList()

    def "test solution"() {
        given:
        int[] resultVals = expected
        ListNode result = ListNodes.of(resultVals).head

        int[] inputVals = list
        ListNode head = ListNodes.of(inputVals).head

        expect:
        result == solution.removeNthFromEnd(head, n)

        where:
        list            | n | expected
//        [1, 2, 3, 4, 5] | 2 | [1, 2, 3, 5]
//        [1]             | 1 | []
        [1, 2]          | 1 | [1]
    }

}