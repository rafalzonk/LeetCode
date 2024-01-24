package leetcode.task19;

import leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null; //empty list
        }

        int myN = innerRemove(head, n);
        if (n == myN) {
            return head.next;
        }

        return head;
    }

    private int innerRemove(ListNode it, int n) {
        if (it.next == null) {
            return 1;
        }

        int myN = innerRemove(it.next, n);
        if (myN == n) {
            it.next = it.next.next;
        }
        return myN + 1;
    }
}
