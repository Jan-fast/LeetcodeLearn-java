public class offer28 {
    public static void main(String[] args) {
        
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