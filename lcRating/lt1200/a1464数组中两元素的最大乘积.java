package lcRating.lt1200;

/**
 * 1464. 数组中两元素的最大乘积
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 */
public class a1464数组中两元素的最大乘积 {
    public int maxProduct(int[] nums) {
        int first = Math.max(nums[0], nums[1]), second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first - 1) * (second - 1);
    }
}
