package Recur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Q90 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Q90 q90 = new Q90();
        q90.subsetsWithDup(nums);
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        set.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int len = ans.size();
            for (int j = 0; j < len; j++) {
                ArrayList<Integer> cur = new ArrayList<>(ans.get(j));
                cur.add(nums[i]);
                if (!set.contains(cur)) {
                    ans.add(cur);
                    set.add(cur);
                }
            }
        }
        return ans;
    }
}
