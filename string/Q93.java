package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Q93 {
    public static void main(String[] args) {
        String s = "25525511135";
        Q93 q93 = new Q93();
        System.out.println(q93.restoreIpAddresses(s));
    }

    //5ms
    List<String> res = new ArrayList<>();
    int len;
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) return res;
        this.len = s.length();
        dfs(s, "", 0, 0);
        return res;
    }

    private void dfs(String s, String ans, int index, int part) {
        if (part == 4) {
            if (index == len) res.add(ans.substring(0, ans.length()-1));
            return;
        }
        if (index == len) return;
        if ((4 - part) * 3 < len - index) return;
        int x = 0;
        for (int i = 0; i < s.length() && i < 3; i++) {
            x = x * 10 + (s.charAt(i) - '0');
            String tmp = ans;
            String partAns = "";
            partAns += String.valueOf(x) + '.';
            ans += partAns;
            if (x > 255 || partAns.charAt(0) == '0' && partAns.length() > 2) break;
            dfs(s.substring(i+1), ans, index + i + 1, part + 1);
            ans = tmp;
            partAns = partAns.substring(0, partAns.length()-1);
            if (s.charAt(0) == '0') break;
        }
    }

    //1ms
    static final int SEG_COUNT = 4;
    List<String> ans2 = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses2(String s) {
        segments = new int[SEG_COUNT];
        dfs2(s, 0, 0);
        return ans2;
    }

    private void dfs2(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans2.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs2(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs2(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    //2ms
    public List<String> restoreIpAddresses3(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }

        Deque<String> path = new ArrayDeque<>(4);
        dfs3(s, len, 0, 4, path, res);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割

    private void dfs3(String s, int len, int begin, int residue, Deque<String> path, List<String> res) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }

            if (residue * 3 < len - i) {
                continue;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs3(s, len, i + 1, residue - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}
