package Ev2024.Ev2024_5;

import java.util.*;

/**
 * 826. 安排工作以达到最大收益
 * https://leetcode.cn/problems/most-profit-assigning-work/description/?envType=daily-question&envId=2024-05-17
 */
public class a826安排工作以达到最大收益 {
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++) {
                jobs[i][0] = difficulty[i];
                jobs[i][1] = profit[i];
            }
            //[[35, 17], [47, 81], [52, 1], [68, 67], [86, 3]]
            //[10, 82, 84, 85, 92]
            Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
            Arrays.sort(worker);
            System.out.println(Arrays.deepToString(jobs));
            System.out.println(Arrays.toString(worker));
            int ans = 0, j = 0, maxProfit = 0;
            for (int w : worker) {
                while (j < n && jobs[j][0] <= w) {
                    maxProfit = Math.max(maxProfit, jobs[j++][1]);
                }
                ans += maxProfit;
            }
            return ans;
        }
    }
}
