package Type_.二叉树;

import Common.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * https://leetcode.cn/problems/trim-a-binary-search-tree/description/
 */
public class a669修剪二叉搜索树 {

    //方法2-前序遍历
    //返回以当前节点为根的树处理完毕之后的根节点
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;

        if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


    //方法1-后序遍历

    class Solution2 {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null)
                return null;

            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);

            if (root.val < low)
                root = root.right;
            else if (root.val > high)
                root = root.left;
            return root;
        }
    }


}
