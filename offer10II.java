public class offer10II {
    public static void main(String[] args) {
        numWaysDP numways = new numWaysDP();
        System.out.println(numways.numWays(7)); 
    }
}

class numWaysDP {
    public int numWays(int n) {
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i % 3] = (dp[(i - 1) % 3] + dp[(i - 2) % 3]) % 1000000007;
        }
        return dp[n % 3];
    }
}