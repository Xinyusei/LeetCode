package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1214. 查找两棵二叉搜索树之和open in new window
 * https://leetcode.cn/problems/two-sum-bsts/description/
 */
public class a1214查找两棵二叉搜索树之和 {
    class Solution {
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            List<Integer> arr1 = traverse(root1);
            List<Integer> arr2 = traverse(root2);
            int m = arr1.size(), n = arr2.size();
            int i = 0, j = n - 1;
            while (i < m && j >= 0) {
                int  sum = arr1.get(i) + arr2.get(j);
                if (sum == target)
                    return true;
                else if (sum < target)
                    i++;
                else
                    j--;
            }
            return false;
        }

        public List<Integer> traverse(TreeNode root) {
            ArrayList<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            list.addAll(traverse(root.left));
            list.add(root.val);
            list.addAll(traverse(root.right));

            return list;

        }
    }
}


