package labuladong.数组.双指针;

/**
 * 27. 移除元素
 * https://leetcode.cn/problems/remove-element/description/
 */
public class a27移除元素 {


    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0, right;
        while (left < n) {
            while (left < n && nums[left] != val)
                left++;
            if (left == n)
                break;
            right = left + 1;
            while (right < n && nums[right] == val)
                right++;
            if (right < n) {
                //交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            } else
                break;
        }
        return left + 1;
    }

    //东哥的想法- 其实只需要保证nums[0~left-1]都!=val就行,其实现的方法不一定需要交换,单纯的赋值也可以
    public int removeElement2(int[] nums, int val) {
        int n = nums.length;
        int left = 0, right = 0;
        while (right < n) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }
}
