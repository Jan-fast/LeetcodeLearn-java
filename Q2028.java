import java.util.Arrays;

public class Q2028 {
    public static void main(String[] args) {
        int[] rolls = {4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3};
        int mean = 2, n = 53;
        System.out.println(missingRolls(rolls, mean, n));
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length, sum = 0;
        for (int i = 0; i < m; i++) sum += rolls[i];
        int rest = mean * (m + n) - sum;
        int x = rest / n, i = 0;
        if (rest > n * 6 || rest <= 0 || x == 0) return new int[0];
        int[] ans = new int[n];
        Arrays.fill(ans, x);
        rest -= x * n;
        while (rest > 0) {
            ans[i] += 1;
            rest -= 1;
            i++;
        }
        return ans;
    }
}
