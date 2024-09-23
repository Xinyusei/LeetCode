package Type_.前缀和.基础;

import Common.TreeNode;

/**
 * @Author: ZJX
 * @Date: 2024/09/23
 * @Description:
 */
public class a437路径总和III {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        //a,b,c
        //0,a,a+b,a+b+c
        private int ans = 0;
        private int N = 0;

        public int pathSum(TreeNode root, int targetSum) {
            this.N = targetSum;
            traverseEveryNode(root);
            return ans;
        }

        private void traverseEveryNode(TreeNode root) {
            if (root == null)
                return;
            dfs(root, 0);
            traverseEveryNode(root.left);
            traverseEveryNode(root.right);
        }

        private void dfs(TreeNode root, long val) {
            if (root == null)
                return;
            val += root.val;
            if (N == val)
                ans++;
            dfs(root.left, val);
            dfs(root.right, val);
        }
    }
}
