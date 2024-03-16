package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/
 */
public class a1448统计二叉树中好节点的数目 {


    int num = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, root.val);
        return num;
    }

    public void traverse(TreeNode root, int pathMax) {
        if (root == null)
            return;

        if (pathMax <= root.val)
            num++;
        pathMax = Math.max(root.val, pathMax);

        traverse(root.left, pathMax);
        traverse(root.right, pathMax);

    }
}
