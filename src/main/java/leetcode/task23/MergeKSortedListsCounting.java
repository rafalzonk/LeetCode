package leetcode.task23;

import leetcode.common.ListNode;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class MergeKSortedListsCounting implements MergeKSortedLists {
    @Override
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        Set<Integer> values = new TreeSet<>();
        ListNode[] listNodes = new ListNode[20000];

        ListNode head = null, tail;
        int min = Integer.MAX_VALUE;

        for (ListNode listNode : lists) {
            while (listNode != null) {
                ListNode next = listNode.next;
                int val = listNode.val + 10000;
                listNode.next = listNodes[val];
                listNodes[val] = listNode;

                if (val <= min) {
                    head = listNode;
                    min = val;
                }

                listNode = next;
                values.add(val);
            }
        }

        if (head == null)
            return null;

        tail = head;
        while (tail.next != null)
            tail = tail.next;


        for (int val : values) {
            if (head.val != val - 10000)
                tail.next = listNodes[val];

            while (tail.next != null)
                tail = tail.next;
        }

        return head;
    }
}
