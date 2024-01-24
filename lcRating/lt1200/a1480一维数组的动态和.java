package lcRating.lt1200;

/**
 * https://leetcode.cn/problems/running-sum-of-1d-array/
 * 1480. 一维数组的动态和
 */
public class a1480一维数组的动态和 {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
