package 周赛.w392;

import java.lang.reflect.Array;
import java.util.Arrays;

public class w392_100277使数组中位数等于K的最少操作数 {

    class Solution {
        public long minOperationsToMakeMedianK(int[] nums, int k) {
            Arrays.sort(nums);
            long ans = 0;
            //2 5 5 6 8
            int n = nums.length, mid = n / 2;
            if (nums[mid] > k) {
                for (int i = mid; i > 0 && nums[i] > k; i--) {
                    ans += nums[i] - k;
                }
            } else if (nums[mid] < k) {
                for (int i = mid; i < n && nums[i] < k; i++) {
                    ans += k - nums[i];
                }
            }
            return ans;
        }
    }
}
