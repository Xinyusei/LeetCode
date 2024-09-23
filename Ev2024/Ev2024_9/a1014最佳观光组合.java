package Ev2024.Ev2024_9;

/**
 * @Author: ZJX
 * @Date: 2024/09/23
 * @Description:
 */
public class a1014最佳观光组合 {
    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            //对Solution2的优化 - 用mx记录 最大的values[i] + i
            //计算的时候 j的位置是固定的 即values[j] - j 是固定的,因此找到 该j之前最大的 values[i] + i 即可。
            int ans = 0, mx = values[0];
            for (int j = 1; j < values.length; j++) {
                ans = Math.max(ans, mx + values[j] - j);
                mx = Math.max(mx, values[j] + j);
            }
            return ans;
        }
    }

    class Solution2 {
        public int maxScoreSightseeingPair(int[] values) {
            int ans = 0;
            for (int j = 1; j < values.length; j++) {
                int cur = values[j];
                for (int i = 0; i < j; i++) {
                    ans = Math.max(ans, values[i] + cur + i - j);
                }
            }
            return ans;
        }
    }
}
