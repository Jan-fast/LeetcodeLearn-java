import java.util.Deque;
import java.util.LinkedList;

public class offer27 {
    public static void main(String[] args) {
        
    }
}

class mirror {
    public TreeNode mirrorTree(TreeNode root) {
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