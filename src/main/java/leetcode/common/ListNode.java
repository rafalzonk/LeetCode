package leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        var node = this;

        sb.append(node.val);
        while (node.next != null) {
            node = node.next;
            sb.append(" -> ");
            sb.append(node.val);
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

        return dis == null && that == null;
    }
}