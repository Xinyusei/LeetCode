package Type_.二叉树;

import Common.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode.cn/problems/delete-node-in-a-bst/description/
 */
public class a450删除二叉搜索树中的节点 {

    /**
     * 返回 删除以key为value的节点后 root节点为根节点的树
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            if (root.left != null) {
                TreeNode right = root.right;
                root = root.left;
                TreeNode p = root;
                while (p.right != null)
                    p = p.right;
                p.right = right;
            } else {
                root = root.right;
            }
        } else if (key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}
