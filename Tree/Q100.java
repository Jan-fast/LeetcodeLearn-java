package Tree;

public class Q100 {
    public static void main(String[] args) {
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preorder(p, q);
    }

    private boolean preorder(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return (preorder(p.left, q.left) & preorder(p.right, q.right));
    }
}
