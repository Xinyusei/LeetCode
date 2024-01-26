package lcRating.lt1200;


/**
 * 1929. 数组串联
 * https://leetcode.cn/problems/concatenation-of-array/
 */
public class a1929数组串联 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[i];
            res[i + n] = nums[i];
        }
        return res;
    }
}
