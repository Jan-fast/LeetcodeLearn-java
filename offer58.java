public class offer58 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int n = 2;
        
        reverseLeftWords solu = new reverseLeftWords();
        System.out.println(solu.substr(s, n));
        System.out.println(solu.traverseStr(s, n));
    }
    
}

class reverseLeftWords {
    public String substr(String s, int n) {
        if (n == s.length()) return s;
        StringBuffer str = new StringBuffer();
        str.append(s);
        str.append(str.substring(0, n));
        str.delete(0, n);
        return str.toString();
    }

    public String traverseStr(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            res.append(s.charAt(i % s.length()));
        return res.toString();
    }
}