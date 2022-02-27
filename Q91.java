public class Q91 {
    public static void main(String[] args) {
        String s = "10";
        Q91 q91 = new Q91();
        System.out.println(q91.numDecodings(s));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int dp = 1, pre = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = dp;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') dp = pre;
                else return 0;
            } else if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                dp = dp + pre;
            }
            pre = tmp;
        }
        return dp;
    }
}
