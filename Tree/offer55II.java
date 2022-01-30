package Tree;

public class offer55II {
    public static void main(String[] args) {
        
    }
    //pre-order
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(maxDeep(root.left) - maxDeep(root.right)) <= 1) return true;
        return false;
    }

    private int maxDeep(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDeep(root.left), maxDeep(root.right)) + 1;
    }

    //postorder
    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1 ? true : false;
    }
    private int recur(TreeNode root) {
        if (root == null) return 0;
        int l = recur(root.left), r = recur(root.right);
        if (l == -1 || r == -1) return -1;
        return Math.abs(l - r) <= 1 ? Math.max(l, r) + 1 : -1;
    }
}
