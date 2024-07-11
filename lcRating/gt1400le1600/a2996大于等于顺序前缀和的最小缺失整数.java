package lcRating.gt1400le1600;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
 */
public class a2996大于等于顺序前缀和的最小缺失整数 {
    class Solution {
        public int missingInteger(int[] nums) {
            int validSum = nums[0];
            int i = 1;
            for (; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] == 1)
                    validSum += nums[i];
                else
                    break;
            }
            Set<Integer> set = new HashSet<>();
            for (i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int ans = validSum;
            while (set.contains(ans)) {
                ans++;
            }
            return ans;
        }
    }
}
