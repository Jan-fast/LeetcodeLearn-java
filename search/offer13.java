package search;
public class offer13 {
    public static void main(String[] args) {
        int m = 11, n = 8, k = 16;
        offer13 mov = new offer13();
        System.out.println(mov.movingCount(m, n, k));
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        int count = findWay(visit, 0, 0, k);
        return count;
    }

    public int findWay(boolean[][] visit, int x, int y, int k) {
        if (x >= visit.length || y >= visit[0].length || judge(x) + judge(y) > k || visit[x][y]) return 0;
        visit[x][y] = true;
        return findWay(visit, x + 1, y, k) + findWay(visit, x, y + 1, k) + 1;
    }

    public int judge(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
