package lcRating.gt1400le1600;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3121. 统计特殊字母的数量 II
 * https://leetcode.cn/problems/count-the-number-of-special-characters-ii/description/
 */
public class a3121统计特殊字母的数量II {
    class Solution1 {
        public int numberOfSpecialChars(String word) {
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                char c = (char) ('a' + i);
                char BigC = (char) ('A' + i);
                int idxC = word.lastIndexOf(c);
                int idxBigC = word.indexOf(BigC);
                if (idxC != -1 && idxBigC != -1 && idxC < idxBigC)
                    ans++;
            }
            return ans;
        }
    }

    class Solution2 {
        public int numberOfSpecialChars(String word) {
            int ans = 0;
            int[] lo = new int[26], up = new int[26];
            Arrays.fill(up, -1);
            Arrays.fill(lo, -1);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                //记录小写字母最后一次出现的位置
                if (c >= 'a' && c <= 'z')
                    lo[c - 'a'] = i;
                //记录大写字母第一次出现的位置
                if (c >= 'A' && c <= 'Z' && up[c - 'A'] == -1)
                    up[c - 'A'] = i;
            }
            for (int i = 0; i < 26; i++) {
                if (lo[i] != -1 && up[i] != -1 && lo[i] < up[i])
                    ans++;
            }
            return ans;
        }
    }
}
