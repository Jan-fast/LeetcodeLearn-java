package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class offer37 {
    public static void main(String[] args) {
        
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder("[");
        if (root == null) return ans.append("]").toString();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                ans.append("null");
            } else {
                ans.append(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            if (!queue.isEmpty()) ans.append(",");
        }
        return ans.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] arrData = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arrData[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!arrData[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(arrData[i]));
                queue.add(node.left);
            }
            i++;
            if (!arrData[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(arrData[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}