package Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class offer32II {
    public static void main(String[] args) {
        
    }
}

class printBinTree2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (queue.isEmpty() != true) {
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            ans.add(level);
        }
        return ans;
    }
}