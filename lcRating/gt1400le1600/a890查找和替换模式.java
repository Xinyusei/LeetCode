package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 890. 查找和替换模式
 * https://leetcode.cn/problems/find-and-replace-pattern/description/
 */
public class a890查找和替换模式 {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                if (match(word, pattern) && match(pattern,word))
                    ans.add(word);
            }
            return ans;
        }

        public boolean match(String word, String pattern) {
            Map<Character, Character> window = new HashMap<>();
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char x = word.charAt(i), y = pattern.charAt(i);
                if (!window.containsKey(y))
                    //建立y -> x 的映射
                    window.put(y, x);
                else {
                    if (x != window.get(y))
                        return false;
                }
            }
            return true;
        }
    }
}
