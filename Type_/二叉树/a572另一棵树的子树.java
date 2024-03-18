package Type_.二叉树;

import Common.TreeNode;

public class a572另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null)
            return subRoot == null;

        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }


    //判断以p、q为根的树是否为相同的树
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // p 、 q均为空
        if (p == null && q == null)
            return true;
        // p 、 q 任意一个为空
        if (p == null || q == null)
            return false;
        //p 、 q 均不为空
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}

