package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 */
public class a236二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    public TreeNode find(TreeNode node, int val1, int val2) {
        if (node == null)
            return null;

        //如果当前node就是p或者q
        if (node.val == val1 || node.val == val2)
            return node;
        //在node的左子树是否存在p或q
        TreeNode left = find(node.left, val1, val2);
        //在node的左子树是否存在p或q
        TreeNode right = find(node.right, val1, val2);

        //p、q分居在node的两侧
        if (left != null && right != null)
            return node;
        //p 、 q位于node.left 或者node.right子树
        return left == null ? right : left;

    }

}
