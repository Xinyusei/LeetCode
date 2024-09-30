package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/30
 * @Description:
 */
public class a46全排列 {
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();
        private final List<Integer> path = new LinkedList<>();
        private boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            this.used = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (nums.length == path.size()) {
                System.out.println("path 满足条件 : " + path);
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                System.out.println("path : " + path + "本轮选择 : " + i);
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums);
                System.out.println("path : " + path + "本轮撤销选择 : " + path.getLast());
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
