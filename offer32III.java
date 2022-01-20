import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class offer32III {
    public static void main(String[] args) {
        
    }
}

class printBinTree3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean lr = false;
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode cur = queue.poll();
                if (!lr) {
                    level.add(0, cur.val);
                } else {
                    level.add(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            ans.add(level);
            lr = !lr;
        }
        return ans;
    }
}