package Tree;

import java.util.HashMap;

public class offer7 {
    public static void main(String[] args) {
        
    }
    int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) dic.put(inorder[i], i);
        return recur(0,0,inorder.length - 1);
    }

    private TreeNode recur(int root, int left, int right) {
        if (left > right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]);
        node.left = recur(root + 1, left, i - 1);
        node.right = recur(root + i - left + 1, i+1, right);
        return node;
    }
}
