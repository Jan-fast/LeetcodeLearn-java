package string;

public class offer20 {
    public static void main(String[] args) {
        String s = "1 ";
        offer20 of20 = new offer20();
        System.out.println(of20.isNumber(s));
    }

    public boolean isNumber(String s) {
        boolean point = false, isE = false, sign = false, isBlank = false, notStart = false;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return false;
        for (; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && isBlank) return false;
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (sign || notStart || i == s.length()-1 || s.charAt(i+1) == ' ') return false;
                sign = true;
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                if (s.charAt(i) != 'e' && s.charAt(i) != 'E' || isE || i == s.length()-1 || !notStart || s.charAt(i+1) == ' ') return false;
                isE = true;
                sign = false;
                notStart = false;
            } else if (s.charAt(i) == '.') {
                if (point || isE || !notStart && (i == s.length()-1 || s.charAt(i+1) == ' ' || s.charAt(i+1) == '+' || s.charAt(i+1) == '-')) return false;
                point = true;
            } else if (s.charAt(i) == ' ') {
                isBlank = true;
            } else {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    notStart = true;
                } else return false;
            }
        }
        return true;
    }
}
