package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的真二叉树
 * https://leetcode.cn/problems/all-possible-full-binary-trees/description/?envType=daily-question&envId=2024-04-02
 */
public class a894所有可能的真二叉树 {
    class Solution1 {
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode> ans = new ArrayList<>();
            if (n % 2 == 0)
                return ans;
            if (n == 1) {
                ans.add(new TreeNode(0));
                return ans;
            }
            for (int i = 1; i < n - 1; i += 2) {
                List<TreeNode> leftTree = allPossibleFBT(i);
                List<TreeNode> rightTree = allPossibleFBT(n - 1 - i);
                for (TreeNode sub1 : leftTree) {
                    for (TreeNode sub2 : rightTree) {
                        TreeNode root = new TreeNode(0,sub1,sub2);
                        ans.add(root);
                    }
                }
            }
            return ans;
        }
    }

    class Solution2 {
        public List<TreeNode> allPossibleFBT(int n) {
            if ((n & 1) == 0)
                return new ArrayList<TreeNode>();

            List<TreeNode>[] dp = new ArrayList[n + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = new ArrayList<TreeNode>();
            }
            dp[1].add(new TreeNode(0));

            for (int i = 3; i <= n; i += 2) {
                for (int j = 1; j < i; j += 2) {
                    for (TreeNode sub1 : dp[j]) {
                        for (TreeNode sub2 : dp[i - 1 - j]) {
                            TreeNode root = new TreeNode(0,sub1,sub2);
                            dp[i].add(root);
                        }
                    }
                }
            }
            return dp[n];
        }
    }
}
