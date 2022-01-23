package linked;

public class offer22 {
    public static void main(String[] args) {
        
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre, cur;
        pre = head;
        cur = head;
        while (k > 0 && cur != null) {
            cur = cur.next;
            k--;
        }
        while (cur != null) {
            cur = cur.next;
            pre = pre.next;
        }
        return pre;
    }
}
