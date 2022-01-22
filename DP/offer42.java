package DP;
public class offer42 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSub maxsub = new maxSub();
        System.out.println(maxsub.maxSubArray(nums));
    }
}

class maxSub {
    public int maxSubArray(int[] nums) {
        int dp = 0, max = Integer.MIN_VALUE;
        dp = nums[0];
        max = dp;
        for (int i = 1; i < nums.length; i++) {
            max = max > dp ? max : dp;
            dp = nums[i] + dp > nums[i] ? nums[i] + dp : nums[i];
        }
        return max;
    }
}