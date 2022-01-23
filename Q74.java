public class Q74 {
    public static void main(String[] args) {
        
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (target > matrix[i][j]) j++;
            else if (target < matrix[i][j]) i--;
            else return true;
        }
        return false;
    }
}
