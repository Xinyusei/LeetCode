package lcRating.lt1200;

/**
 * 977. 有序数组的平方
 * <p>
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
public class a977有序数组的平方 {
    /*
    public int[] sortedSquares(int[] nums) {
        int n = nums.length, minIndex = 0;
        int[] res = new int[n];
        //minIndex指向nums中最小元素
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0)
                nums[i] = -nums[i];
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        int lo = minIndex - 1, hi = minIndex + 1;
        res[0] = nums[minIndex] * nums[minIndex];
        int i = 1;
        for (; i < n && lo >= 0 && hi < n; i++) {
            if (nums[lo] < nums[hi]) {
                res[i] = nums[lo] * nums[lo];
                lo--;
            } else {
                res[i] = nums[hi] * nums[hi];
                hi++;
            }
        }
        for (; i < n && lo >= 0; i++, lo--) {
            res[i] = nums[lo] * nums[lo];
        }
        for (; i < n && hi < n; i++, hi++) {
            res[i] = nums[hi] * nums[hi];
        }
        return res;
    }
    */

    public int[] sortedSquares(int[] nums) {
        //lo 到 minIndex , minIndex 到hi 是一个V字
        int n = nums.length, lo = 0, hi = n - 1, p = n - 1;
        int[] res = new int[n];
        while (lo <= hi) {
            if(Math.abs(nums[lo]) < Math.abs(nums[hi])){
                res[p] = nums[hi] * nums[hi];
                hi --;
            }
            else{
                res[p] = nums[lo] * nums[lo];
                lo ++;
            }
            p--;
        }
        return res;
    }
}
