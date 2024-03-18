package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/description/
 */
public class a513找树左下角的值 {
    private TreeNode res;
    private int depth = 0;

    private int maxDepth = 0;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root);
        return res.val;
    }

    public void traverse(TreeNode root) {
        if (root == null)
            return;

        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            if (root.left == root.right)
                res = root;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
