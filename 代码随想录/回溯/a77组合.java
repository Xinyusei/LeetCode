package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZJX
 * @Date: 2024/09/25
 * @Description: 经典回溯问题
 */
public class a77组合 {
    class Solution {

        private final List<List<Integer>> ans = new ArrayList<>();

        private final List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            traverse(1, n, k);
            return ans;
        }

        public void traverse(int start, int n, int k) {
            //base case
            //到达叶子节点,此时数组中元素个数为k,加入到res中
            if (path.size() == k) {
                //System.out.println("path 满足条件,加入结果中 : " + path);
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = start; i <= n; i++) {
                //剪枝逻辑
                //此时不需要
                //System.out.println("path : " + path.toString() + "本轮选择 : " + i);
                path.addLast(i);
                traverse(i + 1, n, k);
                //System.out.println("path : " + path.toString() + "本轮撤销选择 : " + path.getLast());
                path.removeLast();
            }
        }
    }
}
