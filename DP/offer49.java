package DP;

public class offer49 {
    public static void main(String[] args) {
        int n = 10;
        offer49 of40 = new offer49();
        System.out.println(of40.nthUglyNumber(n));
    }

    public int nthUglyNumber(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            while (dp[a] * 2 <= dp[i-1] && a < n) a++;
            while (dp[b] * 3 <= dp[i-1] && b < n) b++;
            while (dp[c] * 5 <= dp[i-1] && c < n) c++;
            dp[i] = Math.min(dp[a]*2, dp[b]*3) > dp[c]*5 ? dp[c]*5 : Math.min(dp[a]*2, dp[b]*3);
        }
        return dp[n-1];
    }
}
