package Ev2024.Ev2024_6;

import java.util.HashMap;
import java.util.Map;

/**
 * 3038. 相同分数的最大操作数目 I
 * https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-i/description/?envType=daily-question&envId=2024-06-07
 */
public class a3038相同分数的最大操作数目I {
    class Solution {
        public int maxOperations(int[] nums) {
            int ret = 0;
            int key = nums[0] + nums[1];
            for (int i = 2; i < nums.length; i += 2) {
                if(nums[i] + nums[i + 1] != key)
                    break;
                ret++;
            }
            return ret;
        }
    }
}
