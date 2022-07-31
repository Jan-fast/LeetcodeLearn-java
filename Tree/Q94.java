package Tree;

import java.util.ArrayList;
import java.util.List;

public class Q94 {
    public static void main(String[] args) {
        
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) midOrder(root);
        return ans;
    }

    private void midOrder(TreeNode root) {
        if (root.left != null) midOrder(root.left);
        ans.add(root.val);
        if (root.right != null) midOrder(root.right);
    }
}
