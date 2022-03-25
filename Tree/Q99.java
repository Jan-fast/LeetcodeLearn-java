package Tree;

import java.util.LinkedList;

public class Q99 {
    public static void main(String[] args) {
        
    }

    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            if (list.size() > 1) {
                for (int i = list.size()-2; i >= 0; i--) {
                    if (list.get(i + 1).val > list.get(i).val) {
                        break;
                    }
                    int temp = list.get(i+1).val;
                    list.get(i+1).val = list.get(i).val;
                    list.get(i).val = temp;
                }
            }
            root = root.right;
        }
    }
}
