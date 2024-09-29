package 代码随想录.回溯;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/29
 * @Description:
 */
public class a491非递减子序列 {
    class Solution {
        private final List<List<Integer>> res = new LinkedList<>();

        private final List<Integer> path = new LinkedList<>();

        public List<List<Integer>> findSubsequences(int[] nums) {
            backtrack(0, nums);
            return res;
        }

        private void backtrack(int startIndex, int[] nums) {
            if (path.size() >= 2) {
                res.add(new LinkedList<>(path));
            }

            int[] used = new int[201];
            for (int i = startIndex; i < nums.length; i++) {
                if ((!path.isEmpty() && nums[i] < path.getLast()) || used[nums[i] - 100] == 1) {
                    continue;
                }
                path.add(nums[i]);
                used[nums[i] - 100] = 1;
                backtrack(i + 1, nums);
                path.removeLast();

            }
        }
    }
}
