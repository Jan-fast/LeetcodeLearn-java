package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q95 {
    public static void main(String[] args) {
        int n = 3;
        Q95 q95 = new Q95();
        System.out.println(q95.generateTrees(n));
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // 获得所有可行的右子树集合
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        if (n == 0) {
            return pre;
        }
        pre.add(null);
        //每次增加一个数字
        for (int i = 1; i <= n; i++) {
            List<TreeNode> cur = new ArrayList<TreeNode>();
            //遍历之前的所有解
            for (TreeNode root : pre) {
                //插入到根节点
                TreeNode insert = new TreeNode(i);
                insert.left = root;
                cur.add(insert);
                //插入到右孩子，右孩子的右孩子...最多找 n 次孩子
                for (int j = 0; j <= n; j++) {
                    TreeNode root_copy = treeCopy(root); //复制当前的树
                    TreeNode right = root_copy; //找到要插入右孩子的位置
                    int k = 0;
                    //遍历 j 次找右孩子
                    for (; k < j; k++) {
                        if (right == null)
                            break;
                        right = right.right;
                    }
                    //到达 null 提前结束
                    if (right == null)
                        break;
                    //保存当前右孩子的位置的子树作为插入节点的左孩子
                    TreeNode rightTree = right.right;
                    insert = new TreeNode(i);
                    right.right = insert; //右孩子是插入的节点
                    insert.left = rightTree; //插入节点的左孩子更新为插入位置之前的子树
                    //加入结果中
                    cur.add(root_copy);
                }
            }
            pre = cur;
    
        }
        return pre;
    }
    
    private TreeNode treeCopy(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = treeCopy(root.left);
        newRoot.right = treeCopy(root.right);
        return newRoot;
    }

    public List<TreeNode> generateTrees3(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();// 如果left或right为0，就会出现空指针异常。
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);// 如果不加null，那么后面当left或right为0时，就不会执行for循环。而一旦left不执行，right也会被跳过
        //长度为 1 到 n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            //将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;  //左子树的长度
                int right = len - root; //右子树的长度
                /*
                    假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，右边也有两个节点4,5。所以还去dp[2]里面找。
                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
                    我们不妨将1,2加上root，你会发现正好是4,5。
                    所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
                    但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
                */
                // 如果dp[left]里有两种可能，dp[right]里有三种可能，那么总共有6种可能。
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);// 这个是每一种可能的root节点。
                        treeRoot.left = leftTree;
                        //克隆右子树并且加上偏差
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }
    
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
