package leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        var node = this;

        sb.append(node.val);
        while (node.next != null) {
            sb.append(" -> ");
            sb.append(node.val);
            node = node.next;
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof ListNode that)) {
            return false;
        }

        ListNode dis = this;

        while (dis != null && that != null) {
            if (dis.val != that.val)
                return false;
            dis = dis.next;
            that = that.next;
        }

        if (dis == null && that == null) {
            return true;
        }
        return false;
    }
}