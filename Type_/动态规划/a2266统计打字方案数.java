package Type_.动态规划;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-texts/description/">2266统计打字方案数</a>
 */
public class a2266统计打字方案数 {
    class Solution {
        static final int MOD = (int) 1e9 + 7, MX = (int) 1e5 + 1;
        static final int[] f = new int[MX], g = new int[MX];

        static {
            f[0] = g[0] = 1;
            f[1] = g[1] = 1;
            f[2] = g[2] = 2;
            f[3] = g[3] = 4;
            for (int i = 4; i < MX; i++) {
                f[i] = (int) (((long) f[i - 1] + f[i - 2] + f[i - 3]) % MOD);
                g[i] = (int) (((long) g[i - 1] + g[i - 2] + g[i - 3] + g[i - 4]) % MOD);
            }
        }

        public int countTexts(String pressedKeys) {
            int ans = 1, cnt = 0;
            for (int i = 0; i < pressedKeys.length(); i++) {
                cnt++;
                char c = pressedKeys.charAt(i);
                if (i == pressedKeys.length() - 1 || c != pressedKeys.charAt(i + 1)) {
                    if(c != '7' && c != '9'){
                        ans = (int)((long) ans * f[cnt] % MOD);
                    }
                    else
                        ans = (int)((long) ans * g[cnt] % MOD);
                    cnt = 0;
                }
            }
            return ans;
        }
    }
}
