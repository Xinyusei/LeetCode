package 代码随想录.回溯;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/27
 * @Description:
 */
public class a40组合总和II {
    class Solution {
        private int pathSum = 0;
        private final List<Integer> path = new LinkedList<>();
        private final List<List<Integer>> ans = new LinkedList<>();
        private int target;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            //1,1,2,5,6,7,10
            this.target = target;
            backtrack(0, candidates);
            return ans;
        }

        private void backtrack(int start, int[] c) {
            if (pathSum == target) {
                //System.out.println("path : " + path + " 满足条件 ");
                ans.add(new LinkedList<>(path));
                return;
            }

            for (int i = start; i < c.length; i++) {
                if (pathSum + c[i] > target)
                    return;
                //System.out.println("path : " + path + " i的值为 : " + i + " 本轮加入选择 : " + c[i]);
                pathSum += c[i];
                path.add(c[i]);
                backtrack(i + 1, c);
                //System.out.println("path : " + path + " i的值为 : " + i + "  本轮撤销选择 : " + c[i]);
                pathSum -= c[i];
                path.removeLast();

                while (i + 1 < c.length && c[i + 1] == c[i]) {
                    ++i;
                }
            }
        }
    }
}
