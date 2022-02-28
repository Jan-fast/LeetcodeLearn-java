package linked;

public class Q92 {
    public static void main(String[] args) {
        
    }
    //Time: 2N
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        int len = right - left + 1;
        ListNode pre = head, cur = head, end = head;
        for (int i = 1; i < right; i++) {
            if (i < len) end = end.next;
            else {
                if (cur != head) pre = pre.next;
                end = end.next;
                cur = cur.next;
            }
        }
        if (pre != cur) pre.next = end;
        ListNode start = cur.next;
        while (cur != end) {
            cur.next = end.next;
            end.next = cur;
            cur = start;
            start = start.next;
        }
        return head;
    }
    //Time: N
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
