package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/?envType=daily-question&envId=2024-02-26
 */
public class a235二叉搜索树的最近公共祖先 {

    /**
     * 寻找二叉搜索树的最近公共祖先
     *
     * @param root 根节点
     * @param p    节点p
     * @param q    节点q
     * @return 最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);

        return findBST(root, val1, val2);
    }


    TreeNode findBST(TreeNode node, int val1, int val2) {
        if (node == null)
            return null;

        //当前节点的值比更小的值还小,说明两个都位于其右子树
        if (node.val < val1)
            return findBST(node.right, val1, val2);
        //当前节点的值比更大的值还大,说明两个都位于其左子树
        if (node.val > val2)
            return findBST(node.left, val1, val2);

        //node.val >= val1 && node.val <= val2
        return node;
    }
}
