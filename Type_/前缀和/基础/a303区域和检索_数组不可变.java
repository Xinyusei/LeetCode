package Type_.前缀和.基础;

/**
 * @Author: ZJX
 * @Date: 2024/09/08
 * @Description: <a href="https://leetcode.cn/problems/range-sum-query-immutable/">...</a>
 */
public class a303区域和检索_数组不可变 {
    class NumArray {
        private final int[] arr;

        public NumArray(int[] nums) {
            int n = nums.length;
            arr = new int[n + 1];
            for (int i = 0; i < n; i++) {
                arr[i + 1] = arr[i] + nums[i];
            }
            //0,-2,0,1,-4,-2,-3
        }

        public int sumRange(int left, int right) {
            return arr[right + 1] - arr[left];
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
}
