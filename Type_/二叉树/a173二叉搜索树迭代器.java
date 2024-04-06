package Type_.二叉树;

import Common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 * https://leetcode.cn/problems/binary-search-tree-iterator/description/
 */
public class a173二叉搜索树迭代器 {
    class BSTIterator {
        private final List<TreeNode> stack = new LinkedList();

        private void pushLeftBranch(TreeNode p) {
            while (p != null) {
                stack.addFirst(p);
                p = p.left;
            }
        }

        public BSTIterator(TreeNode root) {
            pushLeftBranch(root);
        }

        public int next() {
            TreeNode p = stack.removeFirst();
            pushLeftBranch(p.right);
            return p.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
