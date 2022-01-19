import java.util.Deque;
import java.util.LinkedList;

public class offer26 {
    public static void main(String[] args) {
        
    }
}

//no recur
class subStruc {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (A != null) stack.push(A);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if (cur.val == B.val) {
                if (judge(cur, B)) return true;
            }
            if (cur.left != null) {
                stack.push(cur.left);
            } else if (cur.right != null) {
                stack.push(cur.right);
            } else {
                stack.pop();
            }
        }
        return false;
    }

    public boolean judge(TreeNode cur, TreeNode B) {
        Deque<TreeNode> stackA = new LinkedList<>();
        Deque<TreeNode> stackB = new LinkedList<>();
        stackA.push(cur);
        stackB.push(B);
        while (!stackB.isEmpty()) {
            TreeNode NodeA = stackA.peek();
            TreeNode NodeB = stackB.peek();
            if (NodeA.val != NodeB.val) break;
            if (NodeA.left != null && NodeB.left != null) {
                stackA.push(NodeA.left);
                stackB.push(NodeB.left);
            } else if (NodeA.right != null && NodeB.right != null){
                stackA.push(NodeA.right);
                stackB.push(NodeB.right);
            } else if ((NodeA.left == null && NodeB.left != null) || (NodeA.right == null && NodeB.right != null)) {
                break;
            } else {
                stackA.pop();
                stackB.pop();
            }
        }
        if (stackB.isEmpty()) return true;
        return false;
    }
}

//recur
class subStrucRecur {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == B.val) {
                if (compare(cur, B)) return true;
            }
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
        return false;
    }

    public boolean compare(TreeNode A, TreeNode B) {
        if (A == null && B == null) return true;
        if (A == null || B == null || A.val != B.val) return false;
        return compare(A.left, B.left) && compare(A.right, B.right);
    }
}