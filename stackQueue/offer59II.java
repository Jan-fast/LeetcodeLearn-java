package stackQueue;

import java.util.LinkedList;

public class offer59II {
    public static void main(String[] args) {
        
    }
}

class MaxQueue {
    LinkedList<Integer> queue;
    LinkedList<Integer> max;
    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }
    
    public int max_value() {
        if (max.size() == 0) return -1;
        return max.getFirst();
    }
    
    public void push_back(int value) {
        queue.add(value);
        while (max.size() != 0 && max.getLast() < value) max.pollLast();
        max.add(value);
    }
    
    public int pop_front() {
        if (queue.size() == 0) return -1;
        int x = queue.pollFirst();
        if (x == max.getFirst()) max.pollFirst();
        return x;
    }
}