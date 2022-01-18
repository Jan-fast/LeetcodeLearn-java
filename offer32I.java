import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class offer32I {
    public static void main(String[] args) {
        printBinTree printBTree = new printBinTree();
        printBTree.levelOrder(null);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}

class printBinTree {
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> array = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty() != true) {
            TreeNode cur = queue.removeFirst();
            if (cur == null) break;
            array.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }
}