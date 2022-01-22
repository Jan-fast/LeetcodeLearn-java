package DP;
public class offer63 {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        maxProfitDP maxpro = new maxProfitDP();
        System.out.println(maxpro.maxProfit(prices));
    }
}

class maxProfitDP {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int dp = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = prices[i] >= min ? min : prices[i];
            dp = (prices[i] - min) > dp ? (prices[i] - min) : dp;
        }
        return dp;
    }
}