package Type_.二叉树;

import Common.TreeNode;

import java.rmi.server.RemoteRef;
import java.util.List;

/**
 * 776. 拆分二叉搜索树open in new window
 * <a href="https://leetcode.cn/problems/split-bst/description/">...</a>
 */
public class a776拆分二叉搜索树 {
    //给你一棵二叉搜索树（BST）、它的根结点 `root` 以及目标值 `target`。
    //请将该树按要求拆分为两个子树：
    //其中一个子树结点的值都必须小于等于给定的目标值 `target`；另一个子树结点的值都必须大于目标值 `target`；树中并非一定要存在值为 `target` 的结点。
    //你需要返回拆分后两个子树的根结点 TreeNode，顺序随意


    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[2];

        TreeNode[] ans = new TreeNode[2];
        if (root.val <= target) {
            ans[0] = root;
            TreeNode[] rightArray = splitBST(root.right, target);
            ans[0].right = rightArray[0];
            ans[1] = rightArray[1];
        } else {
            ans[1] = root;
            TreeNode[] leftArray = splitBST(root.left, target);
            ans[1].left = leftArray[1];
            ans[0] = leftArray[0];
        }
        return ans;
    }

}
