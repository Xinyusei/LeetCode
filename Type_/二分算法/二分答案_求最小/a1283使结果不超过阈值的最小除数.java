package Type_.二分算法.二分答案_求最小;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/09/08
 * @Description: <a href="https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold/">...</a>
 * 用时： 13分钟,二分答案求最小
 */
public class a1283使结果不超过阈值的最小除数 {
    class Solution {
        public int smallestDivisor(int[] nums, int threshold) {
            int lo = 1, hi = 1;
            for (int num : nums) {
                hi = Math.max(hi, num);
            }
            int ans = 0;
            while (lo <= hi) {
                //mid 为 当前选择的阈值
                int mid = ((hi - lo) >> 1) + lo;
                int curSum = 0;
                for (int num : nums) {
                    curSum += (num - 1) / mid + 1;
                }
                //如果当前的值小于等于threshold,则当前的mid可以作为ans,继续减小
                if (curSum <= threshold) {
                    ans = mid;
                    hi = mid;
                } else
                    //肯定不符合,增大值
                    lo = mid + 1;
            }
            return ans;
        }

        public int diverse(int a, int b) {
            return (a - 1) / b + 1;
        }
    }
}
