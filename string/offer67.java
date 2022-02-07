package string;

public class offer67 {
    public static void main(String[] args) {
        String str = "+1";
        offer67 of67 = new offer67();
        System.out.println(of67.strToInt(str));
    }

    public int strToInt(String str) {
        if (str.length() == 0 || str == null) return 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (i == str.length()) return 0;
        long num = 0;
        boolean sign = false;
        if (str.charAt(i) == '-') {
            sign = true;
            i++;
        } else if (str.charAt(i) == '+') i++;
        for (; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) < '0' || str.charAt(i) > '9') break;
            int x = str.charAt(i) - '0';
            num = num * 10 + x;
            if (!sign && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign && -num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if (sign) num = -num;
        return (int)num;
    }
}
