package Type_.二叉树;

import Common.TreeNode;

/**
 * LCR 175. 计算二叉树的深度
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/description/
 */
public class LCR175计算二叉树的深度 {
//    public int calculateDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//
//        return traverse(root);
//    }
//    /**
//     * 分解问题-后序遍历
//     *
//     * @param node 当前遍历到的节点
//     * @return 以node节点为根节点的二叉树的最大深度
//     */
//    public int traverse(TreeNode node) {
//        if (node == null)
//            return 0;
//        int leftDepth = traverse(node.left);
//        int rightDepth = traverse(node.right);
//
//        return Math.max(leftDepth, rightDepth) + 1;
//    }


    //方法二-用外部变量记录当前深度以及最大深度
    private int depth = 0;
    private int maxDepth = 0;

    public int calculateDepth(TreeNode root) {
        if (root == null)
            return 0;

        traverse(root);

        return maxDepth;
    }

    /**
     * @param node
     */
    public void traverse(TreeNode node) {
        if (node == null)
            return;
        //前序位置
        depth++;
        if (node.left == node.right)
            maxDepth = Math.max(maxDepth, depth);
        traverse(node.left);
        traverse(node.right);
        //后序位置
        depth--;
    }


}
