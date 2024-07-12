package lcRating.gt1400le1600;

/**
 * https://leetcode.cn/problems/odd-string-difference/description/
 */
public class a2451差值数组不同的字符串 {
    class Solution {
        public String oddString(String[] words) {
            int[] d1 = new int[words[0].length() - 1];
            int[] d2 = new int[words[0].length() - 1];
            for (int i = 1; i < words[0].toCharArray().length; i++) {
                d1[i - 1] = words[0].charAt(i) - words[0].charAt(i - 1);
            }
            boolean flag = true;
            for (int i = 1; i < words[1].toCharArray().length; i++) {
                d2[i - 1] = words[1].charAt(i) - words[1].charAt(i - 1);
                if(d1[i - 1] != d2[i - 1])
                    flag = false;
            }
            for (int i = 2; i < words.length; i++) {
                for (int j = 1; j < words[i].toCharArray().length; j++) {
                    int d = words[i].charAt(j) - words[i].charAt(j - 1);
                    if (flag && d != d1[j - 1])
                        return words[i];
                    if (!flag && d == d1[j - 1])
                        return words[1];
                    if (!flag && d == d2[j - 1])
                        return words[0];
                }
            }
            return null;
        }
    }
}
