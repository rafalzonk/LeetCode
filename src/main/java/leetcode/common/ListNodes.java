package leetcode.common;

import java.util.Collection;
import java.util.List;

public class ListNodes {
    public ListNode head;
    public ListNode tail;
    private int size;

    public int size() {
        return size;
    }

    private ListNodes() {
        size = 0;
    }

    public ListNodes(ListNode listNode) {
        head = tail = listNode;
        size = 1;
    }

    public static ListNodes of(List<ListNode> nodes) {
        ListNodes listNodes = new ListNodes();
        if (nodes == null || nodes.isEmpty()) {
            return listNodes;
        }

        for (ListNode listNode : nodes) {
            listNodes.append(listNode);
        }

        return listNodes;
    }

    public static ListNodes of(int[] values) {
        ListNodes listNodes = new ListNodes();
        if (values == null) {
            return listNodes;
        }
        for (int val : values) {
            listNodes.append(val);
        }
        return listNodes;

    }

    public ListNode append(ListNode listNode) {
        if (tail == null) {
            head = tail = listNode;
        } else {
            tail.next = listNode;
            tail = tail.next;
        }
        size++;
        return head;
    }

    public ListNode append(int val) {
        return append(new ListNode(val));
    }

    public ListNode add(ListNode listNode) {
        listNode.next = head;
        size++;
        head = listNode;
        if (tail == null) {
            tail = head;
        }
        return head;
    }

    public ListNode add(int val) {
        return add(new ListNode(val));
    }


}
