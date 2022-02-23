package linked;

public class Q83 {
    public static void main(String[] args) {
        
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, cur = head;
        while (cur != null) {
            if (cur.val == pre.val) {
                cur = cur.next;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }
        pre.next = cur;
        return head;
    }
}
