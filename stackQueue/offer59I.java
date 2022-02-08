package stackQueue;

import java.util.LinkedList;

public class offer59I {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        offer59I of59 = new offer59I();
        of59.maxSlidingWindow(nums, k);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0]; 
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0, max = nums[0];
        int[] ans = new int[nums.length - k + 1];
        for (; i < k; i++) {
            queue.add(nums[i]);
            max = nums[i] > max ? nums[i] : max;
        }
        ans[0] = max;
        while (i < nums.length) {
            int x = queue.pollFirst();
            if (x == max) {
                max = nums[i - k + 1];
                for (int j = i - k + 1; j < i; j++) max = nums[j] > max ? nums[j] : max;
            }
            queue.add(nums[i]);
            max = nums[i] > max ? nums[i] : max;
            ans[i - k + 1] = max;
            i++;
        }
        return ans;
    }
}
