package Ev2024_1;

import java.util.HashSet;

/**
 * 2670. 找出不同元素数目差数组
 * https://leetcode.cn/problems/find-the-distinct-difference-array/?envType=daily-question&envId=2024-01-31
 */
public class a1_31ez {
    public int[] distinctDifferenceArray(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int[] cntDiff = new int[n + 1];
        //cntDiff[i]表示nums[i]到nums[n-1]不同元素的个数
        for (int i = n - 1; i >= 0; i--) {
            set.add(nums[i]);
            cntDiff[i] = set.size();
        }
        set.clear();
        cntDiff[n] = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            //这一轮set代表nums[0]~nums[i]中不同元素的个数
            set.add(nums[i]);
            res[i] = set.size() - cntDiff[i + 1];
        }
        return res;
    }
}
