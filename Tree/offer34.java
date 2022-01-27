package Tree;

import java.util.LinkedList;
import java.util.List;

public class offer34 {
    public static void main(String[] args) {
        
    }

    LinkedList<List<Integer>> list = new LinkedList<>();
    LinkedList<Integer> road = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root != null) 
            dfs(root, target, 0);
        return list;
    }

    public void dfs(TreeNode root, int target, int sum) {
        sum += root.val;
        road.add(root.val);
        if (sum == target && root.left == null && root.right == null) {
            list.add(new LinkedList<>(road));  //must new a linkedlist!!!
        }
        if (root.left != null) {
            dfs(root.left, target, sum);
        }
        if (root.right != null) {
            dfs(root.right, target, sum);
        }
        road.removeLast();
    }
}