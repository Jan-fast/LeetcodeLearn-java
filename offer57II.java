import java.util.ArrayList;
import java.util.List;

public class offer57II {
    public static void main(String[] args) {
        int target = 9;
        offer57II of57 = new offer57II();
        of57.findContinuousSequence(target);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 2, sum = 3;
        while (i <= j) {
            if (sum == target) {
                int[] ans = new int[j - i + 1];
                for (int k = 0; k < j - i + 1; k++) ans[k] = k + i;
                res.add(ans);
            }
            if (target - sum < j + 1) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
