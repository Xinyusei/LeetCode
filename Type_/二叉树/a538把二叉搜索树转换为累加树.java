package Type_.二叉树;

import Common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 * https://leetcode.cn/problems/convert-bst-to-greater-tree/description/
 */
public class a538把二叉搜索树转换为累加树 {
    private int incr = 0;

    public TreeNode convertBST(TreeNode root) {
        // 使得 每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
        //由于 是在BST中,该节点右子树的值都大于或者等于当前节点的值
        if (root == null)
            return null;
        traverse(root);
        return root;

    }

    /**
     * 函数定义： 返回当前节点转化为累加数后的节点
     *
     * @param root
     * @return
     */
    public void traverse(TreeNode root) {
        if (root == null)
            return;

        //遍历右子树
        traverse(root.right);

        //当前节点,incr为其右子树的累加和
        incr += root.val;
        root.val = incr;

        //遍历左子树
        traverse(root.left);
    }


}
