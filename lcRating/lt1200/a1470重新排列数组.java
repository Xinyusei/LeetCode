package lcRating.lt1200;

/**
 * 1470. 重新排列数组
 * https://leetcode.cn/problems/shuffle-the-array/
 */
public class a1470重新排列数组 {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        for (int i = 0; i < n; i++) {
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[i + n];
        }
        return res;
    }
}
