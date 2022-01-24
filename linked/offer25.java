package linked;

public class offer25 {
    public static void main(String[] args) {
        
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode ans = null, end = null;
        while (l1 != null && l2 != null) {
            ListNode cur = l1.val < l2.val ? l1 : l2;
            l1 = l1 == cur ? l1.next : l1;
            l2 = l2 == cur ? l2.next : l2;
            if (ans == null) {
                ans = cur;
                end = cur;
                continue;
            }
            end.next = cur;
            end = end.next;
        }
        if (l1 != null) {
            end.next = l1;
        } else if (l2 != null) {
            end.next = l2;
        }
        return ans;
    }
}
