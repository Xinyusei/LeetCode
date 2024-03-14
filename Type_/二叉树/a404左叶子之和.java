package Type_.二叉树;

import Common.TreeNode;

/**
 * 404. 左叶子之和
 * https://leetcode.cn/problems/sum-of-left-leaves/description/
 */
public class a404左叶子之和 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    public void traverse(TreeNode node) {
        if (node == null)
            return;

        if (node.left != null && node.left.left == node.left.right)
            sum += node.left.val;

        traverse(node.left);
        traverse(node.right);


    }
}
