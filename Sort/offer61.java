package Sort;
import java.util.Arrays;

public class offer61 {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        offer61 isstra = new offer61();
        System.out.println(isstra.isStraight(nums));
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0], count = 0, i = 0;
        while (i < 4) {
            if (pre == 0) {
                count++;
                i++;
                pre = nums[i];
            } else {
                if (pre + 1 == nums[i + 1]) {
                    i++;
                    pre = nums[i];
                    continue;
                }
                if (count == 0) return false;
                count--;
                pre++;
            }
        }
        return true;
    }
}
