package Type_.二叉树;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
        if (root == null)
            return null;
        //当前节点就是最近公共节点
        if (p.val == q.val)
            return p;
        //将p.val > q.val 的问题都转化为p.val < q.val的问题
        if (p.val > q.val)
            return lowestCommonAncestor(root, q, p);
        //p.val < q.val 且 被root分割成两个子树
        if (p.val <= root.val && q.val >= root.val)
            return root;
        //p.val < q.val 且 位于同一子树中 如果都位于root的左子树
        if (q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        //p.val < q.val 且 位于同一子树中 如果都位于root的右子树
        else
            return lowestCommonAncestor(root.right, p, q);
    }

}
