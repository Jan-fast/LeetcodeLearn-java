public class offer15 {
    public static void main(String[] args) {
        
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            if ((n & 1) == 1) sum++;
            n >>>= 1;
        }
        return sum;
    }

    public int hamming(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= n - 1;
        }
        return ans;
    }
}
