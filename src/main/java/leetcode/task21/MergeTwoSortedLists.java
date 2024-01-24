package leetcode.task21;

import leetcode.common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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

        if(list1 == null) {
            list3.next = list2;
        } else {
            list3.next = list1;
        }

        return result;
    }
}
