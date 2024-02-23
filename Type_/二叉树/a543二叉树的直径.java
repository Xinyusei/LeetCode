package Type_.二叉树;

import Common.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 */
public class a543二叉树的直径 {
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return res;
    }
    private int traverse(TreeNode node) {
        if (node == null)
            return 0;
        int cntLeft = traverse(node.left);
        int cntRight = traverse(node.right);
        int width = cntLeft + cntRight;

        if(res < width)
            res = width;

        return Math.max(cntLeft,cntRight) + 1;

    }
}
