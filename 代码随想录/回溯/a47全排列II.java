package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/30
 * @Description:
 */
public class a47全排列II {
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();
        private final List<Integer> path = new LinkedList<>();
        private boolean[] usedIndex;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            this.usedIndex = new boolean[nums.length];
            backtrack(nums);
            return res;
        }

        private void backtrack(int[] nums) {
            if (nums.length == path.size()) {
                System.out.println("path 满足条件 : " + path);
                res.add(new LinkedList<>(path));
                return;
            }
            boolean[] usedNum = new boolean[21];
            for (int i = 0; i < nums.length; i++) {
                if (usedIndex[i])
                    continue;
                if (usedNum[nums[i] + 10])
                    continue;
                System.out.println("path : " + path + "本轮选择 : " + i);
                path.add(nums[i]);
                usedIndex[i] = true;
                usedNum[nums[i] + 10] = true;
                backtrack(nums);
                System.out.println("path : " + path + "本轮撤销选择 : " + path.getLast());
                path.removeLast();
                usedIndex[i] = false;
            }
        }
    }
}
