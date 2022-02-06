package analog;

public class offer29 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        offer29 of29 = new offer29();
        of29.spiralOrder(matrix);
    }

    public int[] spiralOrder(int[][] matrix) {
        int len = matrix.length * matrix[0].length;
        int[] ans = new int[len];
        int l = 0, r = matrix[0].length, t = 0, b = matrix.length;
        int i = 0, j = 0, direc = 1; // 1: left 2: down 3: right 4: right
        for (int k = 0; k < len; k++) {
            ans[k] = matrix[i][j];
            if (direc == 1) {
                j++;
                if (j == r) {
                    j--;
                    i++;
                    direc = 2;
                    t++;
                }
            } else if (direc == 2) {
                i++;
                if (i == b) {
                    i--;
                    j--;
                    direc = 3;
                    r--;
                }
            } else if (direc == 3) {
                j--;
                if (j < l) {
                    j++;
                    i--;
                    direc = 4;
                    b--;
                }
            } else if (direc == 4) {
                i--;
                if (i < t) {
                    i++;
                    j++;
                    direc = 1;
                    l++;
                }
            }
        }
        return ans;
    }
}
