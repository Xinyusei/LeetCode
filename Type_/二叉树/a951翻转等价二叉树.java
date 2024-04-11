package Type_.二叉树;

import Common.TreeNode;

/**
 * 951. 翻转等价二叉树
 * <a href="https://leetcode.cn/problems/flip-equivalent-binary-trees/description/">...</a>
 */
public class a951翻转等价二叉树 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
                || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));


    }
}
