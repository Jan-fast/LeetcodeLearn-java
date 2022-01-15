public class offer5 {
    public static void main(String[] args) {
        // Solution solu = new Solution();
        String s = "We are happy.";
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                ans.append(s.charAt(i));
            } else {
                ans.append("%20");
            }
        }
        System.out.println(ans.toString());
    }
}