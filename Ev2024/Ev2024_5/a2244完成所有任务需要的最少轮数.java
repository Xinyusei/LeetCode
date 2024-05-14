package Ev2024.Ev2024_5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2244. 完成所有任务需要的最少轮数
 * https://leetcode.cn/problems/minimum-rounds-to-complete-all-tasks/description/?envType=daily-question&envId=2024-05-14
 */
public class a2244完成所有任务需要的最少轮数 {
    class Solution {
        static final int MX = (int) 1e5 + 1;
        static int[] cal = new int[MX];

        static {
            cal[2] = 1;
            cal[3] = 1;
            cal[4] = 2;
            for (int i = 5; i < cal.length; i++) {
                cal[i] = Math.min(cal[i - 2], cal[i - 3]) + 1;
            }
        }

        public int minimumRounds(int[] tasks) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int task : tasks) {
                cnt.put(task, cnt.getOrDefault(task, 0) + 1);
            }
            //2 : 3, 3 : 2, 4 : 5
            int ans = 0;
            for (Integer val : cnt.values()) {
                if(val < 2)
                    return -1;
                //ans += cal[val];
                ans += (val + 2) / 3;
            }
            return ans;
        }
    }
}
