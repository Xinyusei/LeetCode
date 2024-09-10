package Type_.前缀和.基础;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: ZJX
 * @Date: 2024/09/09
 * @Description: <a href="https://leetcode.cn/problems/count-vowel-strings-in-ranges/">2559. 统计范围内的元音字符串数</a>
 * 用时: 11分钟
 */
public class a2559统计范围内的元音字符串数 {
    class Solution {
        static final Set<Character> set = new HashSet<>();

        static {
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');

        }
        public int[] vowelStrings(String[] words, int[][] queries) {
            int[] cnt = new int[words.length + 1];
            for (int i = 0; i < words.length; i++) {
                if (valid(words[i])) {
                    cnt[i + 1] = 1;
                }
                cnt[i + 1] += cnt[i];
                System.out.println(Arrays.toString(cnt));
            }
            //[0,1,1,2,3,4]
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int from = queries[i][0], to = queries[i][1];
                res[i] = cnt[to + 1] - cnt[from];
            }
            return res;
        }

        public boolean valid(String word) {
            return set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1));
        }
    }
}
