package Type_.二叉树;

import Common.TreeNode;

/**
 * 129. 求根节点到叶节点数字之和
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/description/
 */
public class a129求根节点到叶节点数字之和 {
    private int path = 0;
    private int allPath = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return allPath;
    }

    public void traverse(TreeNode node) {
        if (node == null)
            return;

        path *= 10;
        path += node.val;
        if (node.left == node.right)
            allPath += path;
        traverse(node.left);
        traverse(node.right);
        path -= node.val;
        path /= 10;
    }
}
