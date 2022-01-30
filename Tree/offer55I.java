package Tree;

public class offer55I {
    public static void main(String[] args) {
        
    }
    int max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    private void dfs(TreeNode root, int deep) {
        if (root == null) return;
        deep++;
        max = max > deep ? max : deep;
        dfs(root.left, deep);
        dfs(root.right, deep);
        return;
    }
}
