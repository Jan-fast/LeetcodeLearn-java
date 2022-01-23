package DP;

import java.util.HashMap;
import java.util.Map;

public class offer48 {
    public static void main(String[] args) {
        String s = "abba";
        longestLength longest = new longestLength();
        System.out.println(longest.lengthOpt(s));
    }
}

class longestLength {
    //1.0, long time
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0, length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                i = map.get(s.charAt(i)) + 1;
                map.clear();
                length = 0;
            }
            map.put(s.charAt(i), i);
            length++;
            max = max > length ? max : length;
        }
        return max;
    }

    public int lengthOpt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = res > tmp ? res : tmp;
        }
        return res;
    }
}