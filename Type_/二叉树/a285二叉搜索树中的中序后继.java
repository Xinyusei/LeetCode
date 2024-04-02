package Type_.二叉树;

import Common.TreeNode;

/**
 * 285. 二叉搜索树中的中序后继
 * <a href="https://leetcode.cn/problems/inorder-successor-in-bst/description/">...</a>
 */
public class a285二叉搜索树中的中序后继 {

    class Solution1 {

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null)
                return null;

            TreeNode node = null;
            if (root.val > p.val) {
                node = inorderSuccessor(root.left, p);
                if (node == null)
                    node = root;
            }

            if (root.val < p.val) {
                node = inorderSuccessor(root.right, p);
            }

            if (root.val == p.val) {
                node = getMinInorder(root);
            }
            return node;
        }


        public TreeNode getMinInorder(TreeNode root) {
            TreeNode p = root.right;
            while (p != null && p.left != null) {
                p = p.left;
            }
            return p;
        }

    }

    class Solution2 {

        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            TreeNode cur = root, res = null;
            while (cur != null) {
                if (cur.val <= p.val)
                    cur = cur.right;
                else {
                    res = cur;
                    cur = cur.left;
                }
            }
            return res;
        }
    }
}
