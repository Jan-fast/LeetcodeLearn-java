package Tree;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Q106
 */
public class Q106 {
    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        var res = buildTree(inorder, postorder);
        
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0 || inorder.length != postorder.length) {
            return null;
        }
        if (inorder.length == 1) {
            return new TreeNode(inorder[0]);
        }

        List<Integer> inArr = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        List<Integer> postArr = Arrays.stream(postorder).boxed().collect(Collectors.toList());

        var root = createNode(inArr, postArr);

        return root;
    }
    
    private static TreeNode createNode(List<Integer> inArr, List<Integer> postArr) {
        if (inArr.size() == 0) {
            return null;
        }
        if (inArr.size() == 1) {
            return new TreeNode(inArr.get(0));
        }
        var root = new TreeNode(postArr.get(postArr.size() - 1));

        int rootIndex = inArr.indexOf(root.val);

        root.left = createNode(inArr.subList(0, rootIndex),
                postArr.subList(0, rootIndex));

        root.right = createNode(inArr.subList(rootIndex + 1, inArr.size()),
                postArr.subList(rootIndex, postArr.size() - 1));

        return root;
    }
}