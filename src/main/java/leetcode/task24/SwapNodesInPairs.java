package leetcode.task24;

import leetcode.common.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode result = head.next;
        ListNode third = result.next;
        head.next = third;
        result.next = head;

        ListNode prev = head;
        ListNode first, second;

        while ((first = prev.next) != null && (second = first.next) != null) {
            third = second.next;
            prev.next = second;
            second.next = first;
            first.next = third;
            prev = first;
        }

        return result;
    }
}
