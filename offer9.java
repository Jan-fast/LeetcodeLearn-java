import java.util.LinkedList;
//import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
class CQueue {
    // Stack<Integer> stack1;
    // Stack<Integer> stack2;
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        //method1
        /*
        if (stack1.empty()) return -1;
        while (!stack1.empty()) {
            int num = stack1.pop();
            stack2.push(num);
        }
        int ans = stack2.pop();
        while (!stack2.empty()) {
            int num = stack2.pop();
            stack1.push(num);
        }
        return ans;
        */

        //method2
        /*
        if (stack1.empty() && stack2.empty()) return -1;
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            while (!stack1.empty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
            return stack2.pop();
        }
        */

        //method3: LinkedList(faster?)
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                int num = stack1.pop();
                stack2.push(num);
            }
            return stack2.pop();
        }
    }
}