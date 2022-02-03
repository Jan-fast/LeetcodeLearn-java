import java.util.HashMap;
import java.util.Map;

public class offer56I {
    public static void main(String[] args) {
        
    }

    //space: O(N)
    public int[] singleNumbers(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], true);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Boolean> e : map.entrySet()) {
            ans[i] = e.getKey();
            i++;
        }
        return ans;
    }

    //space: O(1)
    public int[] singleNum(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) n ^= nums[i];
        int m = 1;
        while ((n & m) == 0) m <<= 1;
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & m) == 0) x ^= nums[i];
            else y ^= nums[i];
        }
        return new int[]{x, y};
    }
}
