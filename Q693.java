public class Q693 {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hasAlternatingBits(n));
    }

    public static boolean hasAlternatingBits(int n) {
        int flag = n & 1;
        n >>>= 1;
        while (n != 0) {
            int newflag = n & 1;
            if (newflag == flag) return false;
            flag = newflag;
            n >>>= 1;
        }
        return true;
    }

    public static boolean hasAlternatingBits2(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
