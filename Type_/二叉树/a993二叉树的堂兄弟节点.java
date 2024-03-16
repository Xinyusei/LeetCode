package Type_.二叉树;

import Common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 993. 二叉树的堂兄弟节点
 * https://leetcode.cn/problems/cousins-in-binary-tree/description/
 */
public class a993二叉树的堂兄弟节点 {
    TreeNode parentX = null;
    TreeNode parentY = null;

    int deepX, deepY;
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        traverse(root, 1, null);
        return deepX == deepY && parentY != parentX;
    }

    public void traverse(TreeNode root, int deep, TreeNode parent) {
        if (root == null)
            return;

        if (root.val == x) {
            // 找到 x，记录它的深度和父节点
            deepX = deep;
            parentX = parent;
        }
        if (root.val == y) {
            deepY = deep;
            parentY = parent;
        }
        traverse(root.left, deep + 1, root);
        traverse(root.right, deep + 1, root);
    }
}
