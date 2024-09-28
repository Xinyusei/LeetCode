package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/28
 * @Description:
 */
public class a78子集 {
    class Solution {
        private final List<List<Integer>> res = new ArrayList<>();

        private final List<Integer> path = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            //Arrays.sort(nums);
            backtrack(0, nums);
            return res;
        }

        private void backtrack(int startIndex, int[] nums) {
            if (startIndex > nums.length)
                return;
            System.out.println("path 加入结果中 : " + path);
            res.add(new ArrayList<>(path));

            for (int i = startIndex; i < nums.length; i++) {
                System.out.println("path : " + path + "本轮选择 : " + i);
                path.add(nums[i]);
                backtrack(i + 1, nums);
                System.out.println("path : " + path + "本轮撤销选择 : " + path.getLast());
                path.removeLast();
            }
        }
    }
}
