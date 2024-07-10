package lcRating.gt1400le1600;

/**
 * https://leetcode.cn/problems/apply-operations-to-make-string-empty/
 */
public class a3039进行操作使字符串为空 {
    class Solution {
        public String lastNonEmptyString(String s) {

            //a 6
            //b 3
            //c 2
            int mx = 0;
            int[] cnt = new int[256];
            for (char c : s.toCharArray()) {
                cnt[c]++;
                mx = Math.max(mx, cnt[c]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                char v = s.charAt(i);
                if (cnt[v] == mx) {
                    sb.append(v);
                    cnt[v] = -1;
                }
            }
            return sb.reverse().toString();
        }
    }
}
