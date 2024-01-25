package leetcode.task23;

import leetcode.common.ListNode;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }

        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode list3;

        if (list1.val < list2.val) {
            list3 = list1;
            list1 = list1.next;
        } else {
            list3 = list2;
            list2 = list2.next;
        }

        ListNode result = list3;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            list3 = list3.next;
        }

        if (list1 == null) {
            list3.next = list2;
        } else {
            list3.next = list1;
        }

        return result;
    }
}
