package Type_.二叉树;

import Common.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/description/
 */
public class a226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }
}
