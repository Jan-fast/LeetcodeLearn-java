import java.util.Vector;

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
class Solution {
    public int[] reversePrint(ListNode head) {
        Vector<Integer> arr = new Vector<>();
        while (head != null) {
            arr.addElement(head.val);
            head = head.next;
        }
        int[] ans = new int[arr.size()];
        for (int i = arr.size()-1, j = 0; i >= 0; i--, j++) {
            ans[j] = arr.elementAt(i);
        }
        return ans;
    }
}