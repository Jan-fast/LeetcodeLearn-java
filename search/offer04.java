package search;
public class offer04 {
    public static void main(String[] args) {
         
    }
}

class findNumIn2DArr {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) return true;
            else if (matrix[i][j] < target) j++;
            else if (matrix[i][j] > target) i--;
        }
        return false;
    }
}