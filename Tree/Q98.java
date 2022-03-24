package Tree;

import java.util.LinkedList;

public class Q98 {
    public static void main(String[] args) {
        
    }

    LinkedList<Integer> big = new LinkedList<>();
    LinkedList<Integer> small = new LinkedList<>();
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return flag;
    }

    private void dfs(TreeNode root) {
        if (!flag) return;
        if (root == null) return;
        
        for (int i = 0; i < big.size(); i++) {
            if (root.val >= big.get(i)) {
                flag = false;
                return;
            }
        }
        for (int i = 0; i < small.size(); i++) {
            if (root.val <= small.get(i)) {
                flag = false;
                return;
            }
        }

        big.push(root.val);
        dfs(root.left);
        big.pop();
        
        small.push(root.val);
        dfs(root.right);
        small.pop();
    }

    public boolean isValidBST2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int inorder = Integer.MIN_VALUE;
        boolean first = true;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (first) inorder = root.val;
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
