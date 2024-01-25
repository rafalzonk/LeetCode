package leetcode.task23

import leetcode.common.ListNode
import leetcode.common.ListNodes;
import spock.lang.Specification;

class MergeKSortedListsSpec extends Specification {

    MergeKSortedLists solution = new MergeKSortedLists()

    def "test solution"() {
        given:
        def lists = input
        ListNode[] listNodes = new ListNode[input.size()]
        for (i in 0..<input.size()) {
            int[] list = lists[i]
            listNodes[i] = ListNodes.of(list).head
        }

        int[] result = expected
        ListNode expectedResult = ListNodes.of(result).head

        expect:
        expectedResult == solution.mergeKLists(listNodes)

        where:
        input                          | expected
        [[1, 4, 5], [1, 3, 4], [2, 6]] | [1, 1, 2, 3, 4, 4, 5, 6]
        []                             | []
        [[]]                           | []
    }

    def "groovy sucks"() {
        given:
        def lists = input
        println lists
        ListNode[] listNodes = new ListNode[input.size()]
        for (i in 0..<input.size()) {
            int[] list = lists[i]
            println list
            listNodes[i] = ListNodes.of(list).head
        }

        where:
        input                          | _
        []                             | _
        [[]]                           | _
        [[1, 4, 5], [1, 3, 4], [2, 6]] | _
    }

}