package linked;

public class Q86 {
    public static void main(String[] args) {
        
    }

    public ListNode partition(ListNode head, int x) {
        ListNode big = null, small = null;
        ListNode bigcur = null, smallcur = null;

        while (head != null) {
            if (head.val < x) {
                if (small == null) {
                    small = head;
                    smallcur = small;
                } else {
                    smallcur.next = head;
                    smallcur = smallcur.next;
                }
            } else {
                if (big == null) {
                    big = head;
                    bigcur = big;
                } else {
                    bigcur.next = head;
                    bigcur = bigcur.next;
                }
            }
            head = head.next;
        }
        ListNode ans = null;
        if (small != null) {
            smallcur.next = big;
            ans = small;
        } else {
            ans = big;
        }
        if (big != null) bigcur.next = null;
        return ans;
    }
}
