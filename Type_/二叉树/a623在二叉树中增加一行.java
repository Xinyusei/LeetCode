package Type_.二叉树;

import Common.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode.cn/problems/add-one-row-to-tree/description/
 */
public class a623在二叉树中增加一行 {
    private int curDeep = 0;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null)
            return null;
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        curDeep++;
        if (curDeep == depth - 1) {
            TreeNode nodeLeft = new TreeNode(val);
            TreeNode nodeRight = new TreeNode(val);
            nodeLeft.left = root.left;
            root.left = nodeLeft;
            nodeRight.right = root.right;
            root.right = nodeRight;
            return root;
        }
        root.left = addOneRow(root.left, val, depth);
        root.right = addOneRow(root.right, val, depth);
        curDeep--;
        return root;
    }
}
