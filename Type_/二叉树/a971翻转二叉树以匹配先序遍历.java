package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * https://leetcode.cn/problems/flip-binary-tree-to-match-preorder-traversal/description/
 */
public class a971翻转二叉树以匹配先序遍历 {
    boolean canFlip = true;
    List<Integer> change = new ArrayList<>();

    int[] voyage;

    int idx = -1;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;
        traverse(root);

        if (!canFlip)
            return List.of(-1);

        return change;
    }

    public void traverse(TreeNode root) {
        if (root == null || !canFlip)
            return;

        idx++;
        //节点的值与voyage对应下标的值不匹配
        if (voyage[idx] != root.val) {
            canFlip = false;
            return;
        }

        //节点的值与voyage对应下标的值匹配
        int temp = idx + 1;
        if (root.left != null && root.left.val != voyage[temp]) {
            //翻转左右子树
            TreeNode tempLeft = root.left;
            root.left = root.right;
            root.right = tempLeft;
            change.add(root.val);
        }
        traverse(root.left);
        traverse(root.right);
    }
}
