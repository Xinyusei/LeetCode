package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/description/
 */
public class a95不同的二叉搜索树II {

    //在生成所有可行的二叉搜索树的时候，假设当前序列长度为 nnn，如果我们枚举根节点的值为 iii，那么根据二叉搜索树的性质我们可以知道左子树的节点值的集合为 [1…i−1][1 \ldots i-1][1…i−1]，右子树的节点值的集合为 [i+1…n][i+1 \ldots n][i+1…n]。
    //而左子树和右子树的生成相较于原问题是一个序列长度缩小的子问题，因此我们可以想到用回溯的方法来解决这道题目。
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    /* 构造闭区间 [lo, hi] 组成的 BST */
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (lo > hi) {
            allTrees.add(null);
            return allTrees;
        }
        //build(lo, hi) 函数表示当前值的集合为[lo,hi]返回序列[lo,hi] 成的所有可行的二叉搜索树。
        //lo < hi  1 2 3
        //枚举可行根节点
        for (int mid = lo; mid <= hi; mid++) {
            //考虑枚举 [lo,hi],mid为当前二叉搜索树的根 那么序列划分为了[lo,mid-1]和[mid+1,hi]两部分。
            // 获得所有可行的左子树集合 - 里面每一颗子树都可以作为当前mid为根的左子树
            List<TreeNode> leftTree = build(lo, mid - 1);
            // 获得所有可行的右子树集合 - 里面每一颗子数都可以作为当前mid为根的右子树
            List<TreeNode> rightTree = build(mid + 1, hi);
            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根节点 root 的值
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        return allTrees;
    }
}
