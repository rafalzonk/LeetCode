package leetcode.task25;

import leetcode.common.ListNode;

public class ReverseNodesInKGroups {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        int i = 1;
        ListNode middleHead;
        ListNode tail = head;
        while (i < k && tail.next != null) {
            i++;
            tail = tail.next;
        }

        ListNode result, prev;
        if (i == k) {
            result = tail;
            prev = internalReverse(head, tail);
            if (prev.next == null)
                return result;
            i = 1;
        } else
            return head;

        middleHead = prev.next;
        tail = middleHead;
        while (tail.next != null) {
            while (i < k && tail.next != null) {
                i++;
                tail = tail.next;
            }
            if (i == k) {
                prev.next = tail;
                prev = internalReverse(middleHead, tail);
                if (prev.next == null)
                    return result;
                middleHead = prev.next;
                tail = middleHead;
                i = 1;
            }
        }
        return result;
    }

    private ListNode internalReverse(ListNode head, ListNode tail) {
        if (head.next == tail) {
            head.next = tail.next;
            tail.next = head;
        } else {
            ListNode prev = internalReverse(head.next, tail);
            head.next = prev.next;
            prev.next = head;
        }
        return head;
    }
}
