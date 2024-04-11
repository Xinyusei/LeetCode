package Type_.二叉树;

import Common.TreeNode;

/**
 * 101. 对称二叉树
 * <a href="https://leetcode.cn/problems/symmetric-tree/description/">...</a>
 */
public class a101对称二叉树 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isValid(root.left,root.right);
        }

        public boolean isValid(TreeNode root1,TreeNode root2){
            if(root1 == root2)
                return true;
            if(root1 == null || root2 == null)
                return false;
            if(root1.val != root2.val)
                return false;
            return isValid(root1.left,root2.right) && isValid(root1.right,root2.left);
        }
    }
}
