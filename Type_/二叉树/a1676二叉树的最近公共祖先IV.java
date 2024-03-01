package Type_.二叉树;

import Common.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 二叉树的最近公共祖先 IV
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/
 */
public class a1676二叉树的最近公共祖先IV {


    TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        return find(root, set);
    }

    TreeNode find(TreeNode node, Set<Integer> set) {
        if (node == null)
            return null;

        if (set.contains(node.val))
            return node;

        TreeNode left = find(node.left, set);
        TreeNode right = find(node.right, set);

        if (left != null && right != null)
            return node;

        return left == null ? right : left;
    }



}
