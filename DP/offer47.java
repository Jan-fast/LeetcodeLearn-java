package DP;
public class offer47 {
    public static void main(String[] args) {
        int[][] grid = {{1,2,5}, {3,2,1}};
        maxVal maxval = new maxVal();
        System.out.println(maxval.maxValue(grid));
    }
}

class maxVal {
    //space: O(n), dp[] length
    public int maxValue(int[][] grid) {
        if (grid.length == 0) return 0;
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    dp[j] = j == 0 ? grid[0][0] : grid[0][j] + dp[j-1];
                } else if (j == 0){
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = grid[i][j] + dp[j] > dp[j-1] + grid[i][j] ? grid[i][j] + dp[j] : dp[j-1] + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }

    //space: O(1)
    public int maxValue_grid(int[][] grid) {
        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0) {
                    grid[0][j] = j == 0 ? grid[0][0] : grid[0][j] + grid[0][j-1];
                } else if (j == 0) {
                    grid[i][0] = grid[i-1][0] + grid[i][0];
                } else {
                    grid[i][j] = grid[i][j] + grid[i][j-1] > grid[i][j] + grid[i-1][j] ? grid[i][j] + grid[i][j-1] : grid[i][j] + grid[i-1][j];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}