package Recur;

import java.util.LinkedList;

public class offer33 {
    public static void main(String[] args) {
        
    }

    public boolean verifyPostorder(int[] postorder) {
        LinkedList<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) root = stack.pop();
            stack.push(postorder[i]); 
        }
        return true;
    }
}
