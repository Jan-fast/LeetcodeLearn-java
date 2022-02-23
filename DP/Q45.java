package DP;

import java.util.Arrays;

public class Q45 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Q45 q45 = new Q45();
        System.out.println(q45.jump(nums));
        System.out.println(q45.jump2(nums));
    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j + i < n && j <= nums[i]; j++) {
                dp[j + i] = dp[j + i] == 0 ? dp[i] + 1 : dp[j + i];
                if (j + i == n - 1) return dp[n-1];
            }
        }
        return dp[n-1];
    }

    public int jump2(int[] nums) {
        int max = 0, step = 0, end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
