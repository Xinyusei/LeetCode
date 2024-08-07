package lcRating.gt1400le1600;

/**
 * 2825. 循环增长使字符串子序列等于另一个字符串
 * <a href="https://leetcode.cn/problems/make-string-a-subsequence-using-cyclic-increments/description/">...</a>
 *
 * @Author: ZJX
 * @Date: 2024/08/07
 * @Description:
 */
public class a2825循环增长使字符串子序列等于另一个字符串 {
    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            if (str1.length() < str2.length())
                return false;
            int j = 0;
            for (int i = 0; i < str1.length(); i++) {
                char b = str1.charAt(i);
                char c = b != 'z' ? (char) (b + 1) : 'a';
                if (b == str2.charAt(j) || c == str2.charAt(j)) {
                    j++;
                    if (j == str2.length())
                        return true;
                }
            }
            return false;
        }
    }
}
