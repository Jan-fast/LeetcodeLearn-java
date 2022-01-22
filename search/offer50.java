package search;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class offer50 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        firstUniq first = new firstUniq();
        System.out.println(first.firstUniqChar_hash(s));
        System.out.println(first.firstUniqChar_hash2(s));
        System.out.println(first.firstUniqChar_linkedhash(s));
    }
}

class firstUniq {
    //hashmap<char,int>
    public char firstUniqChar_hash(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                s = s.replace(s.charAt(i), '%');
                map.remove(s.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '%') return s.charAt(i);
        }
        return ' ';
    }

    //hashmap<char,bool>
    public char firstUniqChar_hash2(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
           if(d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //linkedhashmap
    public char firstUniqChar_linkedhash(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null) {
                map.put(s.charAt(i), 1);
            } else {
                int x = map.get(s.charAt(i));
                x++;
                map.put(s.charAt(i), x);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey().charValue();
        }
        return ' ';
    }
}