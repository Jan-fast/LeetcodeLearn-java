package Tree;

import java.util.Deque;
import java.util.LinkedList;

//Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class offer36 {
    public static void main(String[] args) {
        
    }

    public Node treeToDoublyList(Node root) {
        Deque<Node> stack = new LinkedList<>();
        Node head = null, parent = null;
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            if (root != null) { 
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (head == null) head = root;
                if (parent != null) {
                    parent.right = root;
                    parent = null;
                }
                if (root.right == null && !stack.isEmpty()) {
                    root.right = stack.peek();
                    root = null;
                } else {
                    parent = root;
                    root = root.right;
                }
            }
        }
        Node pre = head, cur = head.right;
        while (cur != null) {
            cur.left = pre;
            pre = pre.right;
            cur = cur.right;
        }
        cur = head;
        cur.left = pre;
        pre.right = cur;
        return head;
    }
}
