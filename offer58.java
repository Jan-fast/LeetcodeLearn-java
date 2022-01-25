public class offer58 {
    public static void main(String[] args) {
        String s = " ";
        offer58 reverseTest = new offer58();
        System.out.println(reverseTest.reverseWords(s));
    }

    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        StringBuffer ans = new StringBuffer();
        StringBuffer cur = new StringBuffer();
        char pre = ' ';
        int i = s.length() - 1;
        while (s.charAt(i) == ' ') {
            i--;
            if (i == -1) return null;
        }
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                cur.append(s.charAt(i));
            } else if (pre != ' ') {
                cur.reverse();
                cur.append(' ');
                ans.append(cur.toString());
                cur.delete(0, cur.length());
            }
            pre = s.charAt(i);
            i--;
        }
        if (pre != ' ') {
            cur.reverse();
            ans.append(cur.toString());
        } else {
            ans.deleteCharAt(ans.length() - 1);
        }
        return ans.toString();
    }
}
