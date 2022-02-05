public class offer14I {
    public static void main(String[] args) {
        
    }

    public int cuttingRope(int n) {
        int ans = 1;
        while (n > 2) {
            ans *= 3;
            n -= 3;
        }
        if (n == 2) ans *= 2;
        else if (n == 1) {
            ans /= 3;
            ans = ans * 2 * 2;
        }
        return ans;
    }
}
