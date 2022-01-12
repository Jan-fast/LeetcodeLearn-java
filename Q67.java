public class Q67 {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        int n;
        n = Math.max(a.length(), b.length());
        StringBuffer res = new StringBuffer();
        int c = 0; //进位
        for (int i = 0; i < n; i++) {
            c += i < a.length() ? (a.charAt(a.length() - i - 1) - '0') : 0;
            c += i < b.length() ? (b.charAt(b.length() - i - 1) - '0') : 0;
            res.append((char)(c % 2 + '0'));
            c /= 2;
        }
        if (c == 1) {
            res.append('1');
        }
        res.reverse();
        System.out.println(res.toString());
        return;
    }
}