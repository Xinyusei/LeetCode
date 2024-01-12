package Ev2024_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/count-common-words-with-one-occurrence/description/?envType=daily-question&envId=2024-01-12
 * 2085. 统计出现过一次的公共字符串
 */
public class a2085统计出现过一次的公共字符串 {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> seen1 = new HashMap<String, Integer>();
        HashMap<String, Integer> seen2 = new HashMap<String, Integer>();

        for (String s : words1) {
            if (!seen1.containsKey(s)) {
                seen1.put(s, 1);
            } else
                seen1.put(s, seen1.get(s) + 1);
        }
        for (String s : words2) {
            if (!seen2.containsKey(s)) {
                seen2.put(s, 1);
            }else
                seen2.put(s, seen2.get(s) + 1);
        }
        int ans = 0;
        Set<String> keys = seen1.keySet();
        for (String key : keys) {
            if(seen2.containsKey(key) && seen1.get(key) == 1 && seen2.get(key) == 1)
                ans++;
        }
        return ans;
    }
}
