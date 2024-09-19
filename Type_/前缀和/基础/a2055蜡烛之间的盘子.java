package Type_.前缀和.基础;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/19
 * @Description: <a href="https://leetcode.cn/problems/plates-between-candles/description/">...</a>
 */
public class a2055蜡烛之间的盘子 {
    class Solution {
        public int[] platesBetweenCandles(String s, int[][] queries) {
            //000100100000100110010
            //000111222222333455560
            int n = s.length();
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] += preSum[i - 1] + (s.charAt(i - 1) == '*' ? 1 : 0);
            }
            //System.out.println(Arrays.toString(preSum));
            int[] leftIdx = new int[n];
            //leftIdx 数组：对于每个索引 i，leftIdx[i] 存储了从左往右看最近的一根蜡烛的位置。如果左侧没有蜡烛，则为 -1。
            //rightIdx 数组：对于每个索引 i，rightIdx[i] 存储了从右往左看最近的一根蜡烛的位置。如果右侧没有蜡烛，则为 -1。
            for (int i = 0, l = -1; i < n; i++) {
                if (s.charAt(i) == '|')
                    l = i;
                leftIdx[i] = l;
            }
            int[] rightIdx = new int[n];
            for (int i = n - 1, r = -1; i >= 0; i--) {
                if (s.charAt(i) == '|')
                    r = i;
                rightIdx[i] = r;
            }
            //System.out.println("leftIdx = " + Arrays.toString(leftIdx));
            //System.out.println("rightIdx = " + Arrays.toString(rightIdx));
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                //lo = rightIdx[query[0]]：找到查询区间的起点 left 右侧最近的一根蜡烛的位置。
                //hi = leftIdx[query[1]]：找到查询区间的终点 right 左侧最近的一根蜡烛的位置。
                int lo = rightIdx[query[0]], hi = leftIdx[query[1]];
                //System.out.println("lo = " + lo);
                //System.out.println("hi = " + hi);
                //如果 lo 或 hi 为 -1，或者 hi <= lo，说明在查询区间内没有有效的蜡烛对，直接跳过。
                //否则，使用 preSum 数组计算被这两根蜡烛包围的盘子数量：ans[i] = preSum[hi + 1] - preSum[lo]。
                if (hi == -1 || lo == -1 || hi <= lo)
                    continue;
                ans[i] = preSum[hi + 1] - preSum[lo];
            }
            return ans;
        }
    }
}
