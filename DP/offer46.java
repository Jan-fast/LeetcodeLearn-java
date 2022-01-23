package DP;

public class offer46 {
    public static void main(String[] args) {
        int num = 18822;
        translate tran = new translate();
        System.out.println(tran.translateNum(num));
    }
}

class translate {
    public int translateNum(int num) {
        int dp = 1, predp = dp, rest = num, pre = num % 10;
        while (rest >= 10) {
            rest = rest / 10;
            int x = rest % 10;
            int cur = x * 10 + pre;
            if (cur >= 10 && cur <= 25) {
                int newdp = dp + predp;
                predp = dp;
                dp = newdp;
            } else {
                predp = dp;
            }
            pre = x;
        }
        return dp;
    }
}