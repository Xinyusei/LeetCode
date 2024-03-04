package Type_.二叉树;

import Common.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/
 */
public class a701二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
