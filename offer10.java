
public class offer10 {
    public static void main(String[] args) {
        // fibonacci fibo = new fibonacci();
        // System.out.println(fibo.fib(41)); 
        fibonacciNoRecur fibo = new fibonacciNoRecur();
        System.out.println(fibo.fib(5));
    }
}

//recur
class fibonacci {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        double x = (fib(n - 1) + fib(n - 2)) % (1e9 + 7);
        return (int)x;
    }
}

//no recur
class fibonacciNoRecur {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            double x = (dp[(i-1) % 3] + dp[(i-2) % 3]) % (1e9 + 7);
            dp[i % 3] = (int)x;
        }
        return dp[n % 3];
    }
}