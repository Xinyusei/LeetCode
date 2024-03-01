package Type_.二叉树;

import Common.TreeNode;

/**
 * 二叉树的最近公共祖先 II
 * https://leetcode.cn/problemset/?search=1644&page=1
 */
public class a1644二叉树的最近公共祖先II {

    private boolean findP = false;
    private boolean findQ = false;

    TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode treeNode = find(root, p.val, q.val);
        if (!(findP && findQ))
            return null;
        return treeNode;
    }

    TreeNode find(TreeNode node, int val1, int val2) {
        if (node == null)
            return null;

        TreeNode left = find(node.left, val1, val2);
        TreeNode right = find(node.right, val1, val2);

        if (left != null && right != null)
            return node;

        if (left == null && right == null)
            return null;
        if (node.val == val1 || node.val == val2) {
            if (node.val == val1) findP = true;
            if (node.val == val2) findQ = true;
            return node;
        }

        return left == null ? right : left;


    }

}
