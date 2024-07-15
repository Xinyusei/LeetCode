package lcRating.gt1400le1600;

import java.util.Arrays;

/**
 * 1588. 所有奇数长度子数组的和
 * https://leetcode.cn/problems/sum-of-all-odd-length-subarrays/description/
 * 1409分
 */
public class a1588所有奇数长度子数组的和 {
    class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int n = arr.length;
            int[] preSum = new int[n + 1];
            preSum[0] = 0;
            for (int i = 1; i < preSum.length; i++)
                preSum[i] = preSum[i - 1] + arr[i - 1];
            int res = 0;
            //  [ 1, 4, 2, 5, 3 ]
            //[0, 1, 5, 7, 12, 15]
            System.out.println(Arrays.toString(preSum));
            int idx = 1;
            while (idx < preSum.length) {
                for (int i = 0; i + idx < preSum.length; i++) {
                    res += preSum[i + idx] - preSum[i];
                }
                idx += 2;
            }
            return res;
        }
    }
}
