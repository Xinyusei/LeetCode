package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 * <a href="https://leetcode.cn/problems/recover-binary-search-tree/description/"></a>
 */
public class a99恢复二叉搜索树 {
    /**
     * 空间O(n)
     *
     * @param root 根节点
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new LinkedList<>();
        traverse(root, list);
        TreeNode first = null, second = null;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                second = list.get(i + 1);
                if (first == null)
                    first = list.get(i);
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    public void traverse(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        traverse(root.left, list);
        list.add(root);
        traverse(root.right, list);
    }

    private class Solution {
        TreeNode first = null, second = null;
        TreeNode prev = new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            traverse(root);
            if (first != null && second != null) {
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
        }

        public void traverse(TreeNode root) {
            if (root == null)
                return;

            traverse(root.left);
            if (root.val < prev.val) {
                if (first == null)
                    first = prev;
                second = root;
            }
            prev = root;
            traverse(root.right);
        }
    }
}



