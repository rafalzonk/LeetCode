package leetcode.task25

import leetcode.common.ListNode
import leetcode.common.ListNodes;
import spock.lang.Specification;

class ReverseNodesInKGroupsSpec extends Specification {

    ReverseNodesInKGroups solution = new ReverseNodesInKGroups()

    def "test solution"() {
        given:
        int[] result = expected
        ListNode expectedResult = ListNodes.of(result).head

        int[] values = input
        ListNode head = ListNodes.of(values).head

        expect:
        expectedResult == solution.reverseKGroup(head, k)

        where:
        input                    | k | expected
        []                       | 1 | []
        [1]                      | 1 | [1]
        [1, 2]                   | 2 | [2, 1]
        [1, 2, 3]                | 4 | [1, 2, 3]
        [1, 2, 3, 4]             | 1 | [1, 2, 3, 4]
        [1, 2, 3, 4, 5]          | 3 | [3, 2, 1, 4, 5]
        [1, 2, 3, 4, 5, 6, 7]    | 2 | [2, 1, 4, 3, 6, 5, 7]
        [1, 2, 3, 4, 5, 6, 7, 8] | 2 | [2, 1, 4, 3, 6, 5, 8, 7]

    }

    def "test internal reverse"() {
        given:
        int[] values = input
        def listNodes = ListNodes.of(values)
        def head = listNodes.head
        def tail = listNodes.tail

        int[] result = expected
        ListNode expectedResult = ListNodes.of(result).head

        when:
        def returned = solution.internalReverse(head, tail)

        then:
        expectedResult == tail
        returned == head

        where:
        input           | expected
        [1, 2]          | [2, 1]
        [1, 2, 3, 4, 5] | [5, 4, 3, 2, 1]
    }

}