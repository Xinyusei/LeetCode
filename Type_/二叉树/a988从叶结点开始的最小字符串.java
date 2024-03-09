package Type_.二叉树;

import Common.TreeNode;

/**
 * 988. 从叶结点开始的最小字符串
 * https://leetcode.cn/problems/smallest-string-starting-from-leaf/description/
 */
public class a988从叶结点开始的最小字符串 {
    private final StringBuilder path = new StringBuilder();
    String res = null;

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }

    //c
    public void traverse(TreeNode root) {
        if (root == null)
            return;
        path.append((char) ('a' + root.val));
        if (root.left == root.right) {
            //到叶子节点,比较
            StringBuilder reversedPath = path.reverse();
            String truePath = reversedPath.toString();
            //d b a
            if (res == null || res.compareTo(truePath) > 0)
                res = truePath;

            //a b d
            //恢复
            path.reverse();
        }

        traverse(root.left);
        traverse(root.right);
        path.deleteCharAt(path.length() - 1);
    }
}
