package Type_.二叉树;

import Common.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode.cn/problems/search-in-a-binary-search-tree/description/
 */
public class a700二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        TreeNode left = searchBST(root.left, val);
        if (left != null)
            return left;
        if (root.val == val)
            return root;
        return searchBST(root.right, val);
    }
}
