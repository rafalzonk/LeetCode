package leetcode.task21

import leetcode.common.ListNode
import leetcode.common.ListNodes;
import spock.lang.Specification;

class MergeTwoSortedListsSpec extends Specification {

    MergeTwoSortedLists solution = new MergeTwoSortedLists()

    def "test solution"() {

        given:
        int[] resultVals = expected
        ListNode result = ListNodes.of(resultVals).head

        int[] inputVals1 = list1
        ListNode head1 = ListNodes.of(inputVals1).head

        int[] inputVals2 = list2
        ListNode head2 = ListNodes.of(inputVals2).head

        expect:
        result == solution.mergeTwoLists(head1, head2)

        where:
        list1     | list2     | expected
        [1, 2, 4] | [1, 3, 4] | [1, 1, 2, 3, 4, 4]
        []        | []        | []
        []        | [0]       | [0]
        [0]       | []        | [0]
    }
}