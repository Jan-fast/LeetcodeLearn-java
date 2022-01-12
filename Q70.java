public class Q70 {
    public static void main(String[] args) {
        int n = 4;
        //法1:动态规划
        DP dp = new DP();
        System.out.println("dp: " + dp.climbStairs(n));

        //法1优化:滚动数组
        DP_OPT dp_opt = new DP_OPT();
        System.out.println("dp-opt: " + dp_opt.climbStairs(n));

        //法2:矩阵快速幂
        matrixQuick MQ = new matrixQuick();
        int ans = MQ.climbStairs(n);
        System.out.println("matrix: " + ans);

        return;
    }
}

/**
 * 法1:动态规划
 */
class DP {
    public int climbStairs(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                a[i] = 1;
            } else if (i == 1) {
                a[i] = 2;
            } else {
                a[i] = a[i-1] + a[i-2];
            }
        }
        return a[n-1];
    }
}

/**
 * 法1优化:滚动数组
 */
class DP_OPT {
    public int climbStairs(int n) {
        int[] b = new int[3];
        b[0] = 1;
        b[1] = 2;
        for (int i = 2; i < n; i++) {
            b[i%3] = b[(i-1)%3] + b[(i-2)%3];
        }
        return b[(n-1)%3];
    }
}

/**
 * 法2:矩阵快速幂 
 */
class matrixQuick {
    public int climbStairs(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }
}