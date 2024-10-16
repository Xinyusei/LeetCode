package Ev2024.Ev2024_10;

import java.util.Arrays;

/**
 * @Author: ZJX
 * @Date: 2024/10/16
 * @Description:
 */
public class a3194最小元素和最大元素的最小平均值 {
    class Solution {
        public double minimumAverage(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            double res = 1.0 * (nums[0] + nums[n - 1]) / 2;
            for (int i = 1; i < n / 2; i++) {
                /*System.out.println(nums[i]);
                System.out.println(nums[n - 1 - i]);*/
                res = Math.min(res, 1.0 * (nums[i] + nums[n - 1 - i]) / 2);
                //System.out.println(res);

            }
            return res;
        }
    }
}
