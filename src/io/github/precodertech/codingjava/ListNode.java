package io.github.precodertech.codingjava;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val = val; this.next = next;}

    //TO-DO: Fix the concern where blank listnode is created. - last updated on 13th Jan 25
    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder();
        if (node != null) {
            while (node.next != null) {
                sb.append(node.val);
                sb.append(" -> ");
                node = node.next;
            }
            sb.append(node.val);

        }
        return sb.toString();
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
      
}
