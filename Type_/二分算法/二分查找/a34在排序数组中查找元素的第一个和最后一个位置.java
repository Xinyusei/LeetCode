package Type_.二分算法.二分查找;

public class a34在排序数组中查找元素的第一个和最后一个位置 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0)
                return new int[]{-1, -1};
            int[] ans = new int[2];
            ans[0] = leftBound(nums, target);
            ans[1] = rightBound(nums, target);
            return ans;
        }


        //大于等于target的最小索引
        public int leftBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid;
            }
            int index = left;
            if(index >= nums.length || nums[index] != target)
                return -1;
            return index;
        }

        //小于等于target的最大索引
        public int rightBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target)
                    right = mid;
                else
                    left = mid + 1;
            }
            int index = left - 1;
            if(index < 0 || index >= nums.length || nums[index] != target)
                return -1;
            return index;
        }
    }
}
