package Type_.二叉树;

import Common.TreeNode;

/**
 * 1325. 删除给定值的叶子节点
 * <a href="https://leetcode.cn/problems/delete-leaves-with-a-given-value/description/">...</a>
 */
public class a1325删除给定值的叶子节点 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if (root.val == target && root.left == root.right)
            return null;

        return root;

    }
}
