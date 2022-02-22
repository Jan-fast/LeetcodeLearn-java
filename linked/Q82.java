package linked;

public class Q82 {
    public static void main(String[] args) {
        
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, ans = null;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                int x = cur.val;
                while (cur != null && cur.val == x) cur = cur.next;
            } else {
                if (pre == null) ans = cur;
                else pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        if (pre != null) pre.next = cur;
        return ans;
    }
}
