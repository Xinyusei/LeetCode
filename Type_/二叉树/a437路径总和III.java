package Type_.二叉树;

import Common.TreeNode;

public class a437路径总和III {
    private int res = 0;
    private int path;

    public int pathSum(TreeNode root, int targetSum) {
        this.path = targetSum;
        traverseEveryNode(root);
        return res;
    }

    private void traverseEveryNode(TreeNode root) {
        if (root == null)
            return;

        dfs(root, root.val);
        traverseEveryNode(root.left);
        traverseEveryNode(root.right);


    }

    private void dfs(TreeNode root, long val) {
        if (path == val) res++;
        if (root.left != null)
            dfs(root.left, val + root.left.val);
        if (root.right != null)
            dfs(root.right, val + root.right.val);
    }

}
