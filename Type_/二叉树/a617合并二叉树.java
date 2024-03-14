package Type_.二叉树;

import Common.TreeNode;

import java.util.Objects;

/**
 * 617. 合并二叉树
 */
public class a617合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;

    }
}
