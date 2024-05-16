package Ev2024.Ev2024_5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1953. 你可以工作的最大周数
 * https://leetcode.cn/problems/maximum-number-of-weeks-for-which-you-can-work/description/?envType=daily-question&envId=2024-05-16
 */
public class a1953你可以工作的最大周数 {
    class Solution {
        public long numberOfWeeks(int[] milestones) {
            int longest = milestones[0];
            long rest = 0;
            for (int count : milestones) {
                longest = Math.max(longest, count);
                rest += count;
            }
            //5
            //3
            rest -= longest;
            if(longest > rest + 1)
                // 此时无法完成所耗时最长的工作
                return rest * 2 + 1;
            else
                // 此时可以完成所有工作
                return longest + rest;
        }
    }
}
