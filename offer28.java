import java.util.Deque;
import java.util.LinkedList;

public class offer28 {
    public static void main(String[] args) {
        
    }
}

//reverse & compare ??didn't solve
class symmetric {
    public boolean isSymmetric(TreeNode root) {
        TreeNode reverseT = reverse(root);
        Deque<TreeNode> stackA = new LinkedList<>();
        Deque<TreeNode> stackB = new LinkedList<>();
        stackA.push(root);
        stackB.push(reverseT);
        while (!stackA.isEmpty()) {
            TreeNode NodeA = stackA.peek();
            TreeNode NodeB = stackB.peek();
            if (NodeA.val != NodeB.val) return false;
            if (NodeA.left != null) {
                if (NodeB.left == null) return false;
                stackA.push(NodeA.left);
                stackB.push(NodeB.left);
            } else {
                stackA.pop();
                stackB.pop();
                if (NodeA.right != null) {
                    if (NodeB.right == null) return false;
                    stackA.push(NodeA.right);
                    stackB.push(NodeB.right);
                }
            }
        }
        return true;
    }

    public TreeNode reverse(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return root;
    }
}

//recur
class symmetricRecur {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.left, r.right) && recur(l.right, r.left);
    }
}