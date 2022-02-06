package analog;

import java.util.LinkedList;

public class offer31 {
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        offer31 of31 = new offer31();
        of31.validateStackSequences(pushed, popped);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0, j = 0;
        while (i < pushed.length || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                if (i == pushed.length) return false;
                stack.push(pushed[i]);
                i++;
            }
        }
        return true;
    }
}
