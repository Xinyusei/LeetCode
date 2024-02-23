package Type_.二叉树;

import Common.TreeNode;

/**
 * 814. 二叉树剪枝
 * https://leetcode.cn/problems/binary-tree-pruning/description/
 */
public class a814二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 && root.left == root.right)
            return null;
        return root;
    }
}
