package Recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Q78 q78 = new Q78();
        q78.subsets(nums);
    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> ans = new LinkedList<>(); 
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int index) {
        res.add(new LinkedList<>(ans));
        for (int i = index; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, i + 1);
            ans.removeLast();
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
           int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));//这里是关键！
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
