import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Q71 {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";

        //my
        mySolution solution_1 = new mySolution();
        String ans1 = solution_1.simplifyPath(path);
        
        //leetcode
        Solution solution_2 = new Solution();
        String ans2 = solution_2.simplifyPath(path);
        
        System.out.println(ans1);
        System.out.println(ans2);
    }
}

//Solution1(myself)
class mySolution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push("/");
        StringBuffer cur = new StringBuffer();
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/' || i == path.length()-1) {
                if (path.charAt(i) != '/' && i == path.length()-1) {
                    cur.append(path.charAt(i));
                }
                if (cur.length() != 0) {
                    if (cur.toString().equals("..")) {
                        if (stack.peek() != "/") {
                            stack.pop();
                        } 
                    } else if (!cur.toString().equals(".")) {
                        stack.push(cur.toString());
                    }
                }
                cur.delete(0, cur.length());
                continue;
            }
            cur.append(path.charAt(i));
        }
        StringBuffer res = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        while (!stack.peek().equals("/")) {
            temp.append("/" + stack.pop());
            temp.reverse();
            res.append(temp);
            temp.delete(0, temp.length());
        }
        if (res.isEmpty()) res.append("/");
        res.reverse();
        return res.toString();
    }
}

//Leetcode answer
class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            ans.append('/');
        } else {
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }
}