package Ev2024.Ev2024_5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2589. 完成所有任务的最少时间
 * https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/description/?envType=daily-question&envId=2024-05-15
 */
public class a2589完成所有任务的最少时间 {
    class Solution {
        public int findMinimumTime(int[][] tasks) {
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
            int ans = 0;
            int mx = tasks[tasks.length - 1][1];
            boolean[] run = new boolean[mx + 1];
            for (int[] t : tasks) {
                int start = t[0];
                int end = t[1];
                int d = t[2];
                for (int i = start; i <= end; i++) {
                    if(run[i])
                        d--;
                }
                for (int i = end; i >=0 && d > 0; i--) {
                    if (!run[i]) {
                        run[i] = true;
                        d--;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
