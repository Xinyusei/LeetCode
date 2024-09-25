package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/25
 * @Description:
 */
public class a216组合总和III {
    class Solution {
        private final List<List<Integer>> ans = new ArrayList<>();
        private final List<Integer> path = new ArrayList<>();
        private int pathSum = 0;

        public List<List<Integer>> combinationSum3(int k, int n) {
            traverse(1, n, k);
            return ans;
        }

        public void traverse(int start, int n, int k) {
            //base case
            //到达叶子节点,此时数组中元素个数为k,加入到res中
            if (path.size() == k) {
                if (pathSum == n) {
                    //System.out.println("path 满足条件,加入结果中 : " + path);
                    ans.add(new ArrayList<>(path));
                }
                //System.out.println("path 不满足条件,返回 : " + path);
                return;
            }
            for (int i = start; i <= 9; i++) {
                //剪枝逻辑
                if (pathSum + i > n)
                    continue;
                //System.out.println("path : " + path.toString() + "本轮选择 : " + i);
                path.addLast(i);
                pathSum += i;
                traverse(i + 1, n, k);
                //System.out.println("path : " + path.toString() + "本轮撤销选择 : " + path.getLast());
                path.removeLast();
                pathSum -= i;
            }
        }
    }
}
