package Type_.二叉树;


import Common.TreeNode;

/**
 * 100. 相同的树
 * <a href="https://leetcode.cn/problems/same-tree/description/">...</a>
 */
public class a100相同的树 {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == q)
                return true;
            if (p == null || q == null)
                return false;
            if (p.val != q.val)
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
