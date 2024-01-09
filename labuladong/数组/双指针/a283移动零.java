package labuladong.数组.双指针;

/**
 * 283. 移动零
 * https://leetcode.cn/problems/move-zeroes/description/
 */
public class a283移动零 {

    public void moveZeroes(int[] nums) {
        int left = 0, right = 0, n = nums.length;
        while (right < n) {
            //确保nums[0~left-1]均不为0

            //// 去除 nums 中的所有 0，返回不含 0 的数组长度
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        // 将 nums[left..] 的元素赋值为 0
        while (left < n) {
            nums[left++] = 0;
        }
    }
}
