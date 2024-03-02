package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 */
public class a230二叉搜索树中第K小的元素 {
    private int rank = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        if (root == null)
            return;

        traverse(root.left, k);
        //rank就相当于当前元素是第几小的元素
        rank++;
        //当前元素是否是第k小的元素-已经遍历了左子树,左子树的元素均小于当前元素
        if (rank == k) {
            res = root.val;
            return;
        }
        //当前元素并非第k小的元素(k > rank),去右子树找。
        traverse(root.right, k);
    }
}
