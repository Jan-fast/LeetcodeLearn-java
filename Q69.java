public class Q69 {
    public static void main(String[] args) {
        int x = 16;
        if (x == 0 || x == 1) System.out.println(x);
        int l = 0, r = x/2;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(ans);
        return;
    }
}