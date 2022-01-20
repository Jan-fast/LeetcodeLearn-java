import java.util.Deque;
import java.util.LinkedList;

public class offer26 {
    public static void main(String[] args) {
        
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