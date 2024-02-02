package Ev2024.Ev2024_1;

import java.util.HashSet;

/**
 * https://leetcode.cn/problems/find-maximum-number-of-string-pairs/?envType=daily-question&envId=2024-01-17
 * 2744. 最大字符串配对数目
 */
public class a1_17ez {

    /**
     * 哈希set
     * @param words
     * @return
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int ans = 0;
        HashSet<String> seen = new HashSet<>();
        for (String s : words) {
            if (seen.contains(getRevWord(s)))
                ans++;
            else
                seen.add(s);
        }
        return ans;
    }

    private String getRevWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }

    /**
     * 优化后的哈希版本
     * @param words
     * @return
     */
    public int maximumNumberOfStringPairs2(String[] words) {
        int ans = 0;
        //每个字符串仅由两个字符构成
        int[][] seen = new int[26][26];
        for (String s : words) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(1) - 'a';
            if(seen[y][x] != 0)
                ans++;
            else
                seen[x][y] = 1;
        }
        return ans;
    }
    /**
     * 二重循环
     * @param words
     * @return
     */
    public int maximumNumberOfStringPairs3(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isValid(words[i], words[j]))
                    ans++;
            }
        }
        return ans;
    }
    private boolean isValid(String word1, String word2) {
        if (word1.charAt(0) == word2.charAt(1) && word1.charAt(1) == word2.charAt(0))
            return true;
        return false;
    }
}
