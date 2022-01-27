package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class offer54 {
    public static void main(String[] args) {
        
    }

    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (!stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                root = stack.pop();
                count++;
                if (count == k) return root.val;
                root = root.left;
            }
        }
        return 0;
    }
}
