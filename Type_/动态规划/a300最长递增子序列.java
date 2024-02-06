package Type_.动态规划;

import java.util.Arrays;

public class a300最长递增子序列 {
    public int lengthOfLIS(int[] nums) {

        int res = 1, n = nums.length;

        //dp[i]表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[n];

        //假设已经知道dp[0~4] 如何去找dp[5]
        for (int i = 0; i < n; i++) {
            //base case
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                //寻找nums[0~j-1]中比nums[i]小的元素
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > res)
                res = dp[i];
        }
        //debug
//        for (int i = 0; i < dp.length; i++) {
//            System.out.print(dp[i] + " ");
//        }

        return res;
    }
}
