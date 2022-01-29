package Sort;
import java.util.PriorityQueue;
import java.util.Queue;

public class offer41 {
    public static void main(String[] args) {
        MedianFinder find = new MedianFinder();
        find.addNum(6);
        System.out.println(find.findMedian());
        find.addNum(10);
        System.out.println(find.findMedian());
        find.addNum(2);
        System.out.println(find.findMedian());
        find.addNum(6);
        System.out.println(find.findMedian());
        find.addNum(5);
        System.out.println(find.findMedian());
        find.addNum(0);
        System.out.println(find.findMedian());
        find.addNum(6);
        System.out.println(find.findMedian());
        find.addNum(3);
        System.out.println(find.findMedian());
        find.addNum(1);
        System.out.println(find.findMedian());
        find.addNum(0);
        System.out.println(find.findMedian());
        find.addNum(0);
        System.out.println(find.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {
    Queue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }
    public void addNum(int num) {
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}