package Ev2024.Ev2024_6;

/**
 * 522. 最长特殊序列 II
 * 522. 最长特殊序列 II
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/?envType=daily-question&envId=2024-06-17
 */
public class a522最长特殊序列II {
    class Solution {
        public int findLUSlength(String[] strs) {
            int ret = -1;
            for (int i = 0; i < strs.length; i++) {
                boolean isGoing = true;
                String str1 = strs[i];
                for (int j = 0; j < strs.length; j++) {
                    String str2 = strs[j];
                    if (i != j && check(str1, str2)) {
                        isGoing = false;
                        break;
                    }
                }
                if (isGoing) {
                    ret = Math.max(ret, str1.length());
                }
            }
            return ret;
        }

        public boolean check(String str1, String str2) {
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();
            int pt1 = 0, pt2 = 0;
            while (pt1 < s1.length && pt2 < s2.length) {
                if (s1[pt1] == s2[pt2]) {
                    pt1++;
                }
                pt2++;
            }
            return pt1 == s1.length;
        }
    }
}
