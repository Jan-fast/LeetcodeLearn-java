package linked;

public class offer18 {
    public static void main(String[] args) {
        
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre, cur;
        pre = head;
        cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                break;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}