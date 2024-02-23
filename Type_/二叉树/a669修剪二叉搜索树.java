package Type_.二叉树;

import Common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/description/
 */
public class a669修剪二叉搜索树 {

    //方法2-前序遍历
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return traverse(root, low, high);
    }

    /**
     *
     * @param node
     * @param low
     * @param high
     * @return 返回以当前节点为根的树处理完毕之后的根节点
     */
    private TreeNode traverse(TreeNode node, int low, int high) {
        if (node == null)
            return null;

        if (node.val < low)
            //直接返回root.right 等于删除root以及root的左子树
            return traverse(node.right, low, high);
        if (node.val > high)
            //直接返回root.left 等于删除root以及root的右子树
            return traverse(node.left, low, high);
        // 闭区间内的节点无需处理
        node.left = traverse(node.left, low, high);
        node.right = traverse(node.right, low, high);
        return node;
    }

    //方法1-后序遍历

//    public TreeNode trimBST(TreeNode root, int low, int high) {
//        return traverse(root,low,high);
//    }
//    private TreeNode traverse(TreeNode node, int low, int high) {
//        if (node == null)
//            return null;
//
//        node.left = traverse(node.left, low, high);
//        node.right = traverse(node.right, low, high);
//        //后序位置-跟子树有关,需要给函数设置返回值
//        if (node.val < low)
//            node = node.right;
//        else if (node.val > high)
//            node = node.left;
//        return node;
//    }


}
