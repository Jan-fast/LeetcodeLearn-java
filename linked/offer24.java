package linked;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p;
        while (head != null) {
            p = head;
            head = head.next;
            p.next = null;
            stack.push(p);
        }
        ListNode ans = null, q = null;
        while (!stack.isEmpty()) {
            if (ans == null) {
                ans = stack.pop();
                q = ans;
            } else {
                q.next = stack.pop();
                q = q.next;
            }
        }
        return ans;
    }
}