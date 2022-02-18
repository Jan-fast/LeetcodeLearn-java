package Recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    public static void main(String[] args) {
        int n = 1, k = 1;
        Q77 q77 = new Q77();
        q77.combine(n, k);
    }

    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> res = new ArrayList<>();
    int n, k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(0, 1);
        return ans;
    }

    private void dfs(int index, int start) {
        if (start <= n && index < k && n - start < k - index - 1) return;
        if (index == k) {
            ans.add(new LinkedList<>(res));
            return;
        }
        for (int i = start; i <= n; i++) {
            res.add(i);
            dfs(index + 1, i + 1);
            res.remove(res.size()-1);
        }
    }
}
