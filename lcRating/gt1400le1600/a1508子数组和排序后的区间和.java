package lcRating.gt1400le1600;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1508. 子数组和排序后的区间和
 * https://leetcode.cn/problems/range-sum-of-sorted-subarray-sums/
 */
public class a1508子数组和排序后的区间和 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        int m = n * (n + 1) >> 1;
        int[] res = new int[m];
        //循环n次
        int pos = 0;
        for (int i = 0; i < n; i++) {
            //每次从nums[i]开市
            for (int j = i; j < n; j++, pos++) {
                if (j == i)
                    res[pos] = nums[i];
                else
                    res[pos] = res[pos - 1] + nums[j];
            }
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
        int ans = 0;
        for (int i = left - 1; i < right; i++) {
            ans = (ans + res[i]) % MODULO;
        }
        return ans;
    }
}
