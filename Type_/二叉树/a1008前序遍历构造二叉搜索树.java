package Type_.二叉树;

import Common.TreeNode;

/**
 * 1008. 前序遍历构造二叉搜索树
 * https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/description/
 */
public class a1008前序遍历构造二叉搜索树 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bulid(preorder, 0, preorder.length - 1);
    }

    //
    public TreeNode bulid(int[] preorder, int lo, int hi) {
        if (lo > hi)
            return null;

        int rootValue = preorder[lo];
        TreeNode root = new TreeNode(rootValue);
        int rightIdx;
        for (rightIdx = lo + 1; rightIdx <= hi; rightIdx++) {
            if(preorder[rightIdx] > rootValue)
                break;
        }

        root.left = bulid(preorder, lo + 1, rightIdx - 1);
        root.right = bulid(preorder, rightIdx, hi);
        return root;
    }
}
