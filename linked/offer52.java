package linked;

public class offer52 {
    public static void main(String[] args) {
        
    }

    //method 1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode Acur, Bcur;
        int Alen = 0, Blen = 0;
        Acur = headA;
        Bcur = headB;
        while (Acur != null || Bcur != null) {
            Alen = Acur == null ? Alen : Alen + 1;
            Blen = Bcur == null ? Blen : Blen + 1;
            Acur = Acur == null ? null : Acur.next;
            Bcur = Bcur == null ? null : Bcur.next;
        }
        int len = Math.abs(Alen - Blen);
        if (Alen > Blen) {
            while (len > 0) {
                headA = headA.next;
                len--;
            }
        } else {
            while (len > 0) {
                headB = headB.next;
                len--;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) break;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    //method 2
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
