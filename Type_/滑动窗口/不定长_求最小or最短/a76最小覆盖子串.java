package Type_.滑动窗口.不定长_求最小or最短;


import java.util.HashMap;
import java.util.Objects;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/
 */
public class a76最小覆盖子串 {
    public String minWindow(String s, String t) {
        int startIndex = 0, len = s.length() + 1;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> exits = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int valid = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (need.containsKey(ch)) {
                exits.put(ch, exits.getOrDefault(ch, 0) + 1);
                if (Objects.equals(need.get(ch), exits.get(ch)))
                    valid++;
            }
            //缩小窗口
            while (valid == need.size()) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    startIndex = left;
                }
                char de = s.charAt(left);
                if (need.containsKey(de)) {
                    if (need.get(de).equals(exits.get(de)))
                        valid--;
                    exits.put(de, exits.get(de) - 1);
                }
                left++;
            }
        }
        return len == s.length() + 1 ? "" : s.substring(startIndex, startIndex + len);
    }
}
