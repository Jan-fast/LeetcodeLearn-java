package search;
import java.util.HashMap;
import java.util.Map;

public class offer03 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 0, 0, 1};
        RepeatNumber repeatNum = new RepeatNumber();
        System.out.println(repeatNum.hashmapsolu(nums));
        System.out.println(repeatNum.swapInPlace(nums));
    }
}

class RepeatNumber {
    public int hashmapsolu(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                break;
            }
            map.put(nums[i], 1);
        }
        return nums[i];
    }

    public int swapInPlace(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) break;
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            } else {
                i++;
            }
        }
        return nums[i];
    }
}