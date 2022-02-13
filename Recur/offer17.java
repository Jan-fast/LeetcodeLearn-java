package Recur;

public class offer17 {
    public static void main(String[] args) {
        
    }

    StringBuilder res;
    int nine = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res.toString();
    }
    
    private void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res.append(s + ",");
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
