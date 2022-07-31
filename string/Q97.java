package string;

public class Q97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i <= s2.length(); i++) {
            if (s3.charAt(i) != s2.charAt(i)) break;
            dp[0][i] = true;
        }
        for (int i = 1; i <= s1.length(); i++) {
            if (s3.charAt(i) != s1.charAt(i)) break;
            dp[i][0] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i-1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j-1]))
                    dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
