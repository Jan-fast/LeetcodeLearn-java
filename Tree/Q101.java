package Tree;

public class Q101 {
    public static void main(String[] args) {
        
    }

    public boolean isSymmetric(TreeNode root) {
        return preorder(root.left, root.right);
    }

    private boolean preorder(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return (preorder(p.left, q.right) & preorder(p.right, q.left));
    }
}
