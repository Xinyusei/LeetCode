package Type_.二叉树;

import Common.TreeNode;

/**
 * 114. 二叉树展开为链表
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 */
public class a114二叉树展开为链表 {

    /**
     * 通过分解问题的方式得到答案
     *
     * @param root 返回以当前root为根的子树,已经被展开成链表
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        //左子树已经被展开成链表
        flatten(root.left);
        //右子树已经被展开成链表
        flatten(root.right);

        TreeNode p = root.left;
        if (p == null)
            return;
        while (p.right != null)
            p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }


    private TreeNode dummy = new TreeNode(-1);
    private TreeNode p = dummy;

    public TreeNode flatten1(TreeNode root) {
        traverse(root);
        return dummy.right;
    }

    /**
     * 通过遍历的方式得到答案
     */
    public void traverse(TreeNode node) {
        if (node == null)
            return;

        p.right = new TreeNode(node.val);
        p = p.right;

        traverse(node.left);
        traverse(node.right);


    }


}
